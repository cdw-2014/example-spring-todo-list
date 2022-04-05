package me.cweaver.example.todolist.todolist.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.cweaver.example.todolist.todolist.dao.todo.TodoDao;
import me.cweaver.example.todolist.todolist.models.Todo;

@RestController
@RequestMapping("api/todo")
public class TodoController {

    @Autowired
    TodoDao todoService;

    @GetMapping("/id/{id}")
    public ResponseEntity<Todo> getById(@PathVariable int id) {
        Optional<Todo> result = todoService.getById(id);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result.get());
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<List<Todo>> getAllByAssignee(@PathVariable String user) {
        Optional<List<Todo>> result = todoService.getAllByAssignee(user);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result.get());
    }

    @PostMapping()
    public void create(@RequestBody Todo todo) {
        todoService.create(todo);
    }

    @PutMapping()
    public void update(@RequestBody Todo todo) {
        todoService.update(todo);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable int id) {
        todoService.deleteById(id);
    }

}
