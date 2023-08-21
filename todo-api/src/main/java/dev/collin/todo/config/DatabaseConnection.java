package dev.collin.todo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.sqlite.SQLiteConfig;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Configuration
public class DatabaseConnection {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseConnection.class);

    private static final String URL = "jdbc:sqlite:src/main/resources/todo.sqlite";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(URL);
            } catch (ClassNotFoundException | SQLException e) {
                LOG.error("Connection Not Established", e);
            }
        }
        return connection;
    }

    @PostConstruct
    private void createTables() {
        Connection conn = getConnection();
        String query = "" +
                "CREATE TABLE IF NOT EXISTS task (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL," +
                "description TEXT NOT NULL);";

        try (Statement stmt = conn.createStatement();) {
            stmt.execute(query);
        } catch (SQLException e) {
            LOG.error("SQL Exception:", e);
        }

    }

}
