package dev.collin.todo.repository;

import java.sql.SQLException;

public interface IDataRepository {
    public void dropTableIfExists() throws SQLException;
    public void createTableIfExists() throws SQLException;
}
