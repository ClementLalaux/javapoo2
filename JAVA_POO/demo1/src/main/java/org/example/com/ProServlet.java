package org.example.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entities.Produit;
import org.example.services.ProduitService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name="proServlet", value = "/pro")
public class ProServlet extends HttpServlet {

    ProduitService produitService = new ProduitService();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Produit produit = produitService.findById(Integer.parseInt(request.getParameter("id")));
        if(produit != null){
            request.setAttribute("produit", produit);
            request.getRequestDispatcher("produit.jsp").forward(request, response);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(request.getParameter("ref") != null) {
            String ref = request.getParameter("ref");
            Produit produit = new Produit(ref);
            produitService.create(produit);
            out.println("<div>Un seul produit avec la ref : "+ref+"</div>");
        }else {
            out.println("<h1>erreur de données</h1>");
        }

        out.println("</body></html>");
    }

    public void destroy() {

    }

}
