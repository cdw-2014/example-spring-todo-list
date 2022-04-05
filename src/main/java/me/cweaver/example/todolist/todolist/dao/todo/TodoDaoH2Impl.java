package me.cweaver.example.todolist.todolist.dao.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import me.cweaver.example.todolist.todolist.models.Todo;
import me.cweaver.example.todolist.todolist.repositories.TodoRepository;

@Service
@Profile("!local")
public class TodoDaoH2Impl implements TodoDao {

    @Autowired
    private TodoRepository repo;

    @Override
    public Optional<Todo> getById(int id) {
        return repo.findById(id);
    }

    @Override
    public Optional<List<Todo>> getAllByAssignee(String assignee) {
        return repo.findAllByAssignee(assignee);
    }

    @Override
    public void create(Todo todo) {
        repo.save(todo);
    }

    @Override
    public void update(Todo todo) {
        repo.save(todo);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

}
