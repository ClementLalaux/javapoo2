package example.com;

import example.entities.Consultation;
import example.entities.Dossier;
import example.entities.Patient;
import example.services.DossierService;
import example.services.PatientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static example.util.Definition.VIEW_PATH;

@WebServlet(name = "patient", value = "/patient")
public class PatientServlet extends HttpServlet {

    private PatientService patientService;
    private DossierService dossierService;

    public void init(){
        patientService = new PatientService();
        dossierService = new DossierService();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(request.getParameter("recherche") != null) {
            String recherche = request.getParameter("recherche");
            request.setAttribute("patients",patientService.findByName(recherche));
            request.getRequestDispatcher(VIEW_PATH+"patients.jsp").forward(request,response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id") != null){
            int id = Integer.parseInt(request.getParameter("id"));
            Patient patient = patientService.findById(id);
            if(patient !=null ){
                if(patient.getDossier()==null) {
                    Dossier dossier = new Dossier(patient);
                    dossierService.create(dossier);
                    patient.setDossier(dossier);
                    patientService.update(patient);
                    request.setAttribute("dossier",dossier);
                } else {
                    request.setAttribute("dossier",patient.getDossier());
                    List<Consultation> consultationList = patient.getDossier().getConsultations();
                    request.setAttribute("consultations",patient.getDossier().getConsultations());
                }
                request.setAttribute("patient",patient);
                request.getRequestDispatcher(VIEW_PATH+"patient.jsp").forward(request,response);
            }
        } else  {
            request.setAttribute("patients",patientService.findAll());
            request.getRequestDispatcher(VIEW_PATH+"patients.jsp").forward(request,response);
        }
    }
}
