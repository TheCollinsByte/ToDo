package dev.collin.todo.repository;

import java.sql.SQLException;

public interface ITaskRepository extends IDataRepository {
    public String printRecords() throws SQLException;
}
