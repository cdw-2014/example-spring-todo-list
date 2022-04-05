package me.cweaver.example.todolist.todolist.dao.todo;

import java.util.List;
import java.util.Optional;

import me.cweaver.example.todolist.todolist.models.Todo;

public interface TodoDao {

    Optional<Todo> getById(int id);

    Optional<List<Todo>> getAllByAssignee(String assignee);

    void create(Todo todo);

    void update(Todo todo);

    void deleteById(int id);

}
