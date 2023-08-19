package dev.collin.todo.repository;

import com.google.common.base.Preconditions;
import dev.collin.todo.config.SqliteConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class TaskRepository implements ITaskRepository, IDataRepository {
    private static final Logger LOG = LoggerFactory.getLogger(TaskRepository.class);

    private final SqliteConnection sqliteConnection;

    @Autowired
    public TaskRepository(SqliteConnection sqliteConnection) {
        this.sqliteConnection = Preconditions.checkNotNull(sqliteConnection);
    }


    @Override
    public void dropTableIfExists() throws SQLException {

        sqliteConnection.execute(
                """
                        DROP TABLE IF EXISTS tasks;
                    """
        );
    }

    @Override
    public void createTableIfExists() throws SQLException {
        sqliteConnection.execute(
                """
                    
                    CREATE TABLE IF NOT EXISTS tasks (
                        id              INT PRIMARY KEY NOT NULL,
                        title           VARCHAR(255)    NOT NULL,
                        description     TEXT            NOT NULL,
                        due_date        DATETIME,
                        priority        VARCHAR(30),
                        status          VARCHAR(30),
                        category        VARCHAR(30),
                        tags            VARCHAR(30),
                        creation_date   DATETIME,
                        completion_date DATETIME,
                        userId          INT,
                        reminders       DATETIME,
                        comments        TEXT
                    );
                    
                    """);
    }

    @Override
    public String printRecords() throws SQLException {
        return "ON PROGRESS";
    }
}