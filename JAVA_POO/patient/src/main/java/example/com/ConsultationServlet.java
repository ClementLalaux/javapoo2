package example.com;

import example.entities.*;
import example.services.ConsultationService;
import example.services.DossierService;
import example.services.PatientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static example.util.Definition.VIEW_PATH;

@WebServlet(name = "consultation", value = "/consultationForm")
public class ConsultationServlet extends HttpServlet {

    private DossierService dossierService;
    private ConsultationService consultationService;

    public void init(){
        dossierService = new DossierService();
        consultationService =new ConsultationService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id",Integer.parseInt(request.getParameter("id")));
        Consultation consultation = consultationService.findById(Integer.parseInt(request.getParameter("id")));
        if(consultation != null){
            Soins soinsList = consultationService.findById(Integer.parseInt(request.getParameter("id"))).getSoins();
            Prescription prescription = consultationService.findById(Integer.parseInt(request.getParameter("id"))).getPrescription();
            request.setAttribute("soins",soinsList);
            request.setAttribute("prescription",prescription);
        }
        request.getRequestDispatcher(VIEW_PATH+"consultationForm.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(request.getParameter("ajoutConsultation"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
                int id = Integer.parseInt(request.getParameter("id"));
                Dossier dossier = dossierService.findById(id);
                Consultation consultation = new Consultation(date,dossier);
                consultationService.create(consultation);
                request.getRequestDispatcher(VIEW_PATH+"patient.jsp").forward(request,response);
    }
}
