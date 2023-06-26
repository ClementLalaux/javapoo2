package com.example.demo.controller;

import com.example.demo.entities.Todo;
import com.example.demo.services.impl.TodoService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("")
    public ModelAndView getTodos(@CookieValue(value = "choix", required = false) String choix){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("todos.html");
        if(choix != null){
            try {
                if(choix.equals("fait")){
                    modelAndView.addObject("todos",todoService.findEnded(true));
                } else if(choix.equals("pas")){
                    modelAndView.addObject("todos",todoService.findEnded(false));
                } else {
                    modelAndView.addObject("todos",todoService.findAll());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            modelAndView.addObject("todos",todoService.findAll());
        }

        return modelAndView;
    }

    @PostMapping("")
    public String choix(HttpServletRequest request, HttpServletResponse response){
        String choix = request.getParameter("choix");
        Cookie cookie = new Cookie("choix",choix);
        cookie.setMaxAge(36000);
        response.addCookie(cookie);
        return "redirect:/todos";
    }

    @GetMapping("/form")
    public String addTodo(Model model){
        model.addAttribute("todo",new Todo());
        return "formulaire";
    }

    @PostMapping("/create")
    public String postTodo(@ModelAttribute Todo todo){
        if(todo.getId() == null){
            if(todoService.create(todo)){
                return "redirect:/todos";
            }
        } else {
            Todo todoModif = todoService.findById(todo.getId()).get();
            if(todoModif != null){
                todoModif.setTitre(todo.getTitre());
                todoModif.setDescription(todo.getDescription());
                todoModif.setDateTodo(todo.getDateTodo());
                todoModif.setEtat(todo.isEtat());
                if(todoService.update(todoModif)){
                    return "redirect:/todos";
                }
            }
        }
        return "todos/error";
    }

    @GetMapping("/edit/{id}")
    public String editTodo(@PathVariable Integer id, Model model) {
        Todo todo = todoService.findById(id).get();
        model.addAttribute("todo", todo);
        return "formulaire";
    }

    @PostMapping("/edit/{id}")
    public Todo updateTodo(@PathVariable("id") Integer id, @RequestBody Todo todo) {
        Todo todoModif = todoService.findById(id).get();
        if (todoModif != null) {
            todoModif.setTitre(todo.getTitre());
            todoModif.setDescription(todo.getDescription());
            todoModif.setDateTodo(todo.getDateTodo());
            todoModif.setEtat(todo.isEtat());
            if (todoService.update(todoModif)) {
                return todoModif;
            }
        }
        return todoModif;
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") Integer id) {
        Todo todo = todoService.findById(id).get();
        if (todo != null && todoService.delete(todo)) {
            return "redirect:/todos";
        }
        return "Aucun todo avec cet id";
    }



}
