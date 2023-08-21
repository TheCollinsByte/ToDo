package dev.collin.todo.repository;

import com.google.common.base.Preconditions;
import dev.collin.todo.config.DatabaseConnection;
import dev.collin.todo.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTaskRepository implements ITaskRepository {
    private static final Logger LOG = LoggerFactory.getLogger(JdbcTaskRepository.class);

    @Override
    public Task createTask(Task task) {
        String query = "INSERT INTO task (id, title, description) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, task.getId());
            statement.setString(2, task.getTitle());
            statement.setString(3, task.getDescription());
            statement.executeUpdate();

            return task;        // Return the created task
        } catch (SQLException e) {
            LOG.error("SQL Exception Error:", e);
            return null;
        }
    }

    @Override
    public List<Task> getAllTask() throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM task";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {  // Iterate through each row in the result set
                Task task = new Task();
                task.setId(resultSet.getLong("id"));
                task.setTitle(resultSet.getString("title"));
                task.setDescription(resultSet.getString("description"));

                tasks.add(task);
            }

        } catch (SQLException e) {
            LOG.error("SQL Exception:", e);
        }

        return tasks;
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