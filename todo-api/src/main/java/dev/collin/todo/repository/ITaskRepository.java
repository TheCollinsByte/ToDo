package dev.collin.todo.repository;

import dev.collin.todo.model.Task;

import java.sql.SQLException;
import java.util.List;

public interface ITaskRepository {
    Task createTask(Task task) throws SQLException;
    List<Task> getAllTask() throws SQLException;
    Task getTaskById(Long id) throws SQLException;
    Task updateTask(Long id, Task task) throws SQLException;
    void deleteTask(Long id) throws SQLException;
}
