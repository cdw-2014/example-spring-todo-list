package me.cweaver.example.todolist.todolist.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.cweaver.example.todolist.todolist.models.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {

    Optional<List<Todo>> findAllByAssignee(String assignee);

}
