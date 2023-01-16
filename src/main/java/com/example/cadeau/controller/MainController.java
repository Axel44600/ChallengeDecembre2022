package com.example.cadeau.controller;

import com.example.cadeau.entity.Todo;
import com.example.cadeau.form.TodoForm;
import com.example.cadeau.service.CadeauService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private CadeauService cadeauService;
    @GetMapping("")
    public String todoHome(Model model) {
        List<Todo> listTodos = cadeauService.getTodoList();
        model.addAttribute("listTodos", listTodos);
        return "index";
    }

    @GetMapping("/aboutTodo/{id}")
    public String todoAbout(@PathVariable("id") int id, Model model) {
        model.addAttribute("todo", cadeauService.getTodoById(id));
        return "aboutTodo";
    }

    @GetMapping("/createTodo")
    public String createTodo() {
        return "createTodo";
    }

    @RequestMapping("/deleteTodo/{id}")
    public String deleteTodo(@PathVariable("id") int id) {
        cadeauService.deleteTodo(id);
        return "todo-deleted-success";
    }

    @PostMapping("/updateTodo/{id}")
    public String updateTodo(@PathVariable("id") int id, @ModelAttribute TodoForm form) {
        String titre = form.getTitre();
        String description = form.getDescription();
        String adresse = form.getAdresse();
        String cadeau = form.getCadeau();
        Boolean checkin = form.getCheckin();

        cadeauService.updateTodo(id, titre, description, adresse, cadeau, checkin);
        return "todo-modified-success";
    }

    @PostMapping("/create")
    public String createTodo(@ModelAttribute TodoForm form) {
        Todo todo = new Todo();
        todo.setTitre(form.getTitre());
        todo.setDescription(form.getDescription());
        todo.setAdresse(form.getAdresse());
        todo.setCadeau(form.getCadeau());
        todo.setCheckin(false);

        cadeauService.createTodo(todo);
        return "todo-created-success";
    }


    public CadeauService getCadeauService() {
        return cadeauService;
    }

    public void setCadeauService(CadeauService cadeauService) {
        this.cadeauService = cadeauService;
    }
}
