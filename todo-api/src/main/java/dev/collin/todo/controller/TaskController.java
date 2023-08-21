package dev.collin.todo.controller;

import dev.collin.todo.model.Task;
import dev.collin.todo.repository.ITaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/v1/todo")
public class TaskController {

    private static final Logger LOG = LoggerFactory.getLogger(TaskController.class);

    @Autowired private ITaskRepository JdbcTaskRepository;

    @RequestMapping(path = "task", method = RequestMethod.POST)
    public Task createTask(@RequestBody Task task) throws SQLException {

        return JdbcTaskRepository.createTask(task);
    }

    @RequestMapping(path = "tasks", method = RequestMethod.GET)
    public List<Task> getTasks() throws SQLException {

        return JdbcTaskRepository.getAllTask();
    }

    @RequestMapping(path = "task/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getTask(@PathVariable int id) {

        return ResponseEntity.ok("OK");
    }

    @RequestMapping(path = "task/{id}", method = RequestMethod.PUT)
    public Task updateTask(@PathVariable long id, @RequestBody Task task) throws SQLException {
        task.setId(id);
        return JdbcTaskRepository.updateTask(task);
    }

    @RequestMapping(path = "task/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTask(@PathVariable int id) {

        return ResponseEntity.ok("OK");
    }
}
