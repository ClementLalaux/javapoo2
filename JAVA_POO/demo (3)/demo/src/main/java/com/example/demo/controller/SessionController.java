package com.example.demo.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("session")
public class SessionController {

    @Autowired
    HttpSession session;

    @GetMapping("/connecte")
    public ModelAndView connecte(){
        ModelAndView modelAndView = new ModelAndView();
        if(session.getAttribute("pseudo") != null  &&session.getAttribute("mdp") != null){
            modelAndView.setViewName("connecte");
        } else {
            modelAndView.setViewName("connexion");
        }

        return modelAndView;
    }

    @GetMapping("/connexion")
    public ModelAndView connexion() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("connexion");
        return modelAndView;
    }

    @PostMapping("/connexion")
    public String connexion(@RequestParam("pseudo") String pseudo,@RequestParam("mdp") String mdp ){
        session.setMaxInactiveInterval(6000);
        if(pseudo != "" && mdp != ""){
            session.setAttribute("pseudo", pseudo);
            session.setAttribute("mdp",mdp);
        }
        return "redirect:/session/connecte";
    }


}
