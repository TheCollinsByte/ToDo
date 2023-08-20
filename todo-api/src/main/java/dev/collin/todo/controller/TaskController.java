package dev.collin.todo.controller;

import dev.collin.todo.repository.ITaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/todo")
public class TaskController {

    private static final Logger LOG = LoggerFactory.getLogger(TaskController.class);

    @Autowired private ITaskRepository TaskRepository;

    @RequestMapping(path = "task", method = RequestMethod.POST)
    public ResponseEntity<String> createTask() {

        return ResponseEntity.ok("OK");
    }

    @RequestMapping(path = "tasks", method = RequestMethod.GET)
    public ResponseEntity<String> getTasks() {

        try {
            String res = TaskRepository.getTasks();
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @RequestMapping(path = "task/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getTask(@PathVariable int id) {

        return ResponseEntity.ok("OK");
    }

    @RequestMapping(path = "task/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTask(@PathVariable int id) {

        return ResponseEntity.ok("OK");
    }

    @RequestMapping(path = "task/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTask(@PathVariable int id) {

        return ResponseEntity.ok("OK");
    }
}
