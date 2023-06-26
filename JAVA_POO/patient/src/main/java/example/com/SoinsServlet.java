package example.com;

import example.entities.Consultation;
import example.entities.Dossier;
import example.entities.Soins;
import example.services.ConsultationService;
import example.services.DossierService;
import example.services.PrescriptionService;
import example.services.SoinsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


import static example.util.Definition.VIEW_PATH;

@WebServlet(name = "soins", value = "/soins")
public class SoinsServlet extends HttpServlet {

    private SoinsService soinsService;
    private ConsultationService consultationService;

    public void init(){
        soinsService = new SoinsService();
        consultationService =new ConsultationService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id",Integer.parseInt(request.getParameter("id")));
        request.getRequestDispatcher(VIEW_PATH+"soins.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("soins" )!= null){
            String soins = request.getParameter("soins");
            int id = Integer.parseInt(request.getParameter("id"));
            Consultation consultation = consultationService.findById(id);
            Soins soinsAjout = new Soins(soins);
            soinsService.create(soinsAjout);
            consultation.setSoins(soinsAjout);
            consultationService.update(consultation);
        }
        request.getRequestDispatcher(VIEW_PATH+"patient.jsp").forward(request,response);
    }

}
