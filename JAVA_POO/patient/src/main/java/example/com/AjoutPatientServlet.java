package example.com;

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

import static example.util.Definition.VIEW_PATH;

@WebServlet(name = "ajoutPatient", value = "/ajoutPatient")
public class AjoutPatientServlet extends HttpServlet {

    private PatientService patientService;
    private DossierService dossierService;

    public void init(){
        patientService = new PatientService();
        dossierService = new DossierService();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        if(request.getParameter("nom") != null && request.getParameter("prenom") !=null){
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            Patient patient = new Patient(nom,prenom);
            patientService.create(patient);
            request.setAttribute("patient",patient);
            request.getRequestDispatcher(VIEW_PATH+"patient.jsp").forward(request,response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher(VIEW_PATH+"ajoutPatient.jsp").forward(request,response);
    }

}
