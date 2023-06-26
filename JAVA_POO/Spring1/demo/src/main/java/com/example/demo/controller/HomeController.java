package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HomeController {

    @RequestMapping("/")
    public String getHome(){
        return "Hello les coupains";
    }

    @RequestMapping("/toto")
    public String getToto(){
        return "Hello les totos";
    }

}
