package dev.collin.todo.repository;

import java.sql.SQLException;

public interface ITaskRepository {
    public String createTask() throws SQLException;
    public String getTask() throws SQLException;
    public String getTasks() throws SQLException;
    public String updateTask() throws SQLException;
    public String deleteTask() throws SQLException;
}
