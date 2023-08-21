package dev.collin.todo.config;

import dev.collin.todo.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.sqlite.SQLiteConfig;

import javax.annotation.PreDestroy;
import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class SqliteConnection implements Closeable {

    private static final Logger LOG = LoggerFactory.getLogger(SqliteConnection.class);

    @FunctionalInterface
    public interface PreparedStatementConsumer {
        public void consume(PreparedStatement preparedStatement) throws SQLException;
    }

    @FunctionalInterface
    public interface ResultSetConsumer {
        public void consume(ResultSet resultSet) throws SQLException;
    }

    private static Connection getConnection(Path dbPath) throws SQLException {
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        return DriverManager.getConnection("jdbc:sqlite:" + dbPath, config.toProperties());
    }

    private final Connection connection;


    /** For Testing **/
    public SqliteConnection(Path dbPath) throws SQLException {
        this.connection = getConnection(dbPath);
        LOG.info("SQLITE Database Connection Established (Test)");
    }

    /** For Spring. */
    public SqliteConnection() throws SQLException {
        this.connection = getConnection(Path.of("todo.sqlite"));
        LOG.info("SQLITE Database Connection Established (Spring)");
    }

    public void execute(String sql) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        }
    }

    public void executeQuery(String sql, ResultSetConsumer resultSetConsumer) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            resultSetConsumer.consume(rs);
        }
    }

    public void prepareStatement(String sql, PreparedStatementConsumer preparedStatementConsumer) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatementConsumer.consume(preparedStatement);
        }
    }

    @Override
    @PreDestroy
    public void close() throws IOException {
        try {
            this.connection.close();
        } catch (SQLException e) {
            LOG.warn("Unable to close JDBC Connection.", e);
        }
    }
}
