package com.example.cadeau.service;

import com.example.cadeau.entity.Todo;
import com.example.cadeau.repository.CadeauRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadeauService {

    @Autowired
    private CadeauRepositoryInterface cadeauRepository;

    public List<Todo> getTodoList() {
        return cadeauRepository.findAll();
    }

    public Todo getTodoById(int id) {
        return cadeauRepository.findById(id);
    }

    public Todo updateTodo(int id, String titre, String description, String adresse, String cadeau, Boolean checkin) {
        Todo todo = cadeauRepository.findById(id);
        todo.setTitre(titre);
        todo.setDescription(description);
        todo.setAdresse(adresse);
        todo.setCadeau(cadeau);
        todo.setCheckin(checkin);

        return cadeauRepository.save(todo);
    }

    public Todo createTodo(Todo todo) {
        return cadeauRepository.save(todo);
    }

    public void deleteTodo(int id) {
        cadeauRepository.deleteById(id);
    }

    public CadeauRepositoryInterface getCadeauRepository() {
        return cadeauRepository;
    }

    public void setCadeauRepository(CadeauRepositoryInterface cadeauRepository) {
        this.cadeauRepository = cadeauRepository;
    }
}
