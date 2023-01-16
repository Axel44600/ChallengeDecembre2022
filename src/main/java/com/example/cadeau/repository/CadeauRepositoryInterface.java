package com.example.cadeau.repository;

import com.example.cadeau.entity.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CadeauRepositoryInterface extends CrudRepository<Todo, Integer> {
    List<Todo> findAll();
    Todo findById(int id);

    Todo save(Todo todo);

    void deleteById(int id);
}
