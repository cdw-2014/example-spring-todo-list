package me.cweaver.example.todolist.todolist.dao.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import me.cweaver.example.todolist.todolist.models.Todo;

@Service
@Profile("local")
public class TodoDaoArrayImpl implements TodoDao {

    List<Todo> todos = new ArrayList<>();

    @Override
    public Optional<Todo> getById(int id) {
        List<Todo> todo = todos.stream().filter(t -> t.getId() == id).collect(Collectors.toList());
        return todo.size() > 0 ? Optional.of(todo.get(0)) : Optional.empty();
    }

    @Override
    public Optional<List<Todo>> getAllByAssignee(String assignee) {
        return Optional.of(todos.stream().filter(t -> t.getAssignee().equals(assignee)).collect(Collectors.toList()));
    }

    @Override
    public void create(Todo todo) {
        todo.setId(todos.size() + 1);
        todos.add(todo);
    }

    @Override
    public void update(Todo todo) {
        todos = todos.stream().map(t -> {
            if (t.getId() == todo.getId()) {
                return todo;
            }
            return t;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        todos = todos.stream().filter(t -> t.getId() != id).collect(Collectors.toList());
    }

}
