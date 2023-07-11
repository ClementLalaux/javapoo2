package com.example.demo.controller;

import com.example.demo.entities.Utilisateur;
import com.example.demo.services.UtilisateurService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UtilisateurController{

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private HttpServletResponse _response;

    @GetMapping("form")
    public ModelAndView signIn(){
        ModelAndView modelAndView = new ModelAndView("user-form");
        return modelAndView;
    }

    @PostMapping("sign-in-submit")
    public ModelAndView submitSignIn(@RequestParam String email, @RequestParam String password) throws IOException, Exception {
        ModelAndView modelAndView = new ModelAndView("user-form");
        if(utilisateurService.createUser(email,password)) {
            _response.sendRedirect("/user/login");
        }
        modelAndView.addObject("email", email);
        return modelAndView;
    }

    @GetMapping("login")
    public ModelAndView getLogin() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @PostMapping("login-submit")
    public ModelAndView submitLogin(@RequestParam String email, @RequestParam String password) throws IOException {

            if(utilisateurService.login(email, password)) {
                _response.sendRedirect("/login");
            }
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }


}
