package dev.collin.todo.repository;

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
public class TaskRepository implements ITaskRepository {
    private static final Logger LOG = LoggerFactory.getLogger(TaskRepository.class);

    Task task;
    Connection connection = DatabaseConnection.getConnection();

    @Autowired
    public TaskRepository(Task task) {
        this.task = task;
    }

    @Override
    public Task createTask(Task task) {
        String query = "INSERT INTO task (title, description) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
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

        try (PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {  // Iterate through each row in the result set
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
        String query = "SELECT * FROM task WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    task.setId(resultSet.getLong("id"));
                    task.setTitle(resultSet.getString("title"));
                    task.setDescription(resultSet.getString("description"));
                    return task;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;    // No task found
    }

    @Override
    public Task updateTask(Task task) throws SQLException {

        String query = "UPDATE task SET title = ?, description = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setLong(3, task.getId());
            statement.executeUpdate();

            return task;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteTask(Long id) throws SQLException {
        String query = "DELETE FROM task WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}