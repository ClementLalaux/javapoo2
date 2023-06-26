package example.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Dossier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String addresse;

    @OneToOne
    private Patient patient;
    @OneToMany(mappedBy = "dossier",fetch = FetchType.EAGER)
    private List<Consultation> consultations;

    public Dossier() {
    }

    public Dossier(Patient patient) {
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public void addConsultation(Consultation consultation){
        this.getConsultations().add(consultation);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Dossier{" +
                "id=" + id +
                ", addresse='" + addresse + '\'' +
                ", consultations=" + consultations +
                '}';
    }
}
