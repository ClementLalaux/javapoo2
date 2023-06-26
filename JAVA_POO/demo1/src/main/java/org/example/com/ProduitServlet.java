package org.example.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Ihm;
import org.example.entities.Produit;
import org.example.services.ProduitService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name="produitServlet", value = "/produit")
public class ProduitServlet extends HttpServlet {

    ProduitService produitService = new ProduitService();
    private List<Produit> produitList;

    public void init() {
        produitList = produitService.findAll();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(request.getParameter("id") != null){
            int id = Integer.parseInt(request.getParameter("id"));
            out.println("<h1>Produit avec l'id : "+produitService.findById(id).getReference() +"</h1>");
        } else {
            out.println("<h1>Liste des produits</h1>");
            for(Produit p : produitList) {
                out.println("<div>"+p.getMarque() +" " + p.getReference() + "</div>");
            }
        }
        out.println("</body></html>");*/

        request.setAttribute("produits", produitList);
        request.getRequestDispatcher("produits.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(request.getParameter("reference") != null && request.getParameter("marque") !=null) {
            String ref = request.getParameter("reference");
            String marque = request.getParameter("marque");
            Produit produit = new Produit(marque,ref);
            produitService.create(produit);
        }

    }

    public void destroy() {

    }

}
