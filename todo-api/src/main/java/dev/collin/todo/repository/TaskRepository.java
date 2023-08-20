package dev.collin.todo.repository;

import com.google.common.base.Preconditions;
import dev.collin.todo.config.SqliteConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskRepository implements ITaskRepository {
    private static final Logger LOG = LoggerFactory.getLogger(TaskRepository.class);

    private final SqliteConnection sqliteConnection;

    @Autowired
    public TaskRepository(SqliteConnection sqliteConnection) {
        this.sqliteConnection = Preconditions.checkNotNull(sqliteConnection);
    }

    @Override
    public String createTask() throws SQLException {
        return "SQL Statement";
    }

    @Override
    public String getTask() throws SQLException {
        return "SQL Statement";
    }

    @Override
    public String getTasks() throws SQLException {
        return "SQL Statement";
    }

    @Override
    public String updateTask() throws SQLException {
        return "SQL Statement";
    }

    @Override
    public String deleteTask() throws SQLException {
        return "SQL Statement";
    }
}