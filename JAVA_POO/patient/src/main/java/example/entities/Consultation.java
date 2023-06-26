package example.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date dateConsultation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dossier_id")
    private Dossier dossier;

    @OneToOne
    private Soins soins;

    @OneToOne
    private Prescription prescription;


    public Consultation() {
    }

    public Consultation(Dossier dossier) {
        this.dossier = dossier;
    }

    public Consultation(Date dateConsultation, Dossier dossier) {
        this.dateConsultation = dateConsultation;
        this.dossier = dossier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public Soins getSoins() {
        return soins;
    }

    public void setSoins(Soins soins) {
        this.soins = soins;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", dateConsultation=" + dateConsultation +
                ", dossier=" + dossier +
                ", soins=" + soins +
                ", prescription=" + prescription +
                '}';
    }
}
