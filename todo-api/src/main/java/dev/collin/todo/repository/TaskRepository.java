package dev.collin.todo.repository;

import com.google.common.base.Preconditions;
import dev.collin.todo.config.SqliteConnection;
import dev.collin.todo.model.Task;
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
    public Task createTask(Task task) throws SQLException {
        return null;
    }

    @Override
    public List<Task> getAllTask() throws SQLException {
        return null;
    }

    @Override
    public Task getTaskById(Long id) throws SQLException {
        return null;
    }

    @Override
    public Task updateTask(Long id, Task task) throws SQLException {
        return null;
    }

    @Override
    public void deleteTask(Long id) throws SQLException {

    }
}