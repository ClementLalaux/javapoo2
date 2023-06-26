package example.com;

import example.entities.Consultation;
import example.entities.Prescription;
import example.entities.Soins;
import example.services.ConsultationService;
import example.services.PrescriptionService;
import example.services.SoinsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

import static example.util.Definition.VIEW_PATH;

@WebServlet(name = "prescription", value = "/prescription")
public class PrescriptionServlet extends HttpServlet {

    private PrescriptionService prescriptionService;
    private ConsultationService consultationService;

    public void init(){
        prescriptionService = new PrescriptionService();
        consultationService =new ConsultationService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id",Integer.parseInt(request.getParameter("id")));
        request.getRequestDispatcher(VIEW_PATH+"prescription.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            Part fichier = request.getPart("fichier");
            String fichierNom = fichier.getSubmittedFileName();
            String uploadPath = getServletContext().getRealPath("/") + "fichiers";

            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }

            fichier.write(uploadPath + File.separator + fichierNom);

            Consultation consultation = consultationService.findById(id);
            Prescription prescription = new Prescription();
            prescription.setFichier(uploadPath + File.separator + fichierNom);
            prescriptionService.create(prescription);
            consultation.setPrescription(prescription);
            consultationService.update(consultation);
            request.getRequestDispatcher(VIEW_PATH+"patient.jsp").forward(request,response);
    }

}
