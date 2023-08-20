package dev.collin.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/todo")
public class TaskController {
    @RequestMapping(path = "task", method = RequestMethod.POST)
    public ResponseEntity<String> create() {

        return ResponseEntity.ok("OK");
    }

    @RequestMapping(path = "tasks", method = RequestMethod.GET)
    public ResponseEntity<String> getTasks() {

        return ResponseEntity.ok("OK");
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
