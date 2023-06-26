package com.example.demo4.controller;

import com.example.demo4.entity.Plateau;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static com.example.demo4.util.Definition.VIEW_PATH;

@WebServlet(name="plateau",value = "/plateau")
public class PlateauServlet extends HttpServlet {

    private Plateau plateau;

    public void init(){
        plateau = new Plateau();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        plateau.remplirLaGrille();
        request.setAttribute("plateau",plateau);
        request.getRequestDispatcher(VIEW_PATH + "/plateau.jsp").forward(request, response);

    }



}
