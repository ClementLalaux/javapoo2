package example.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Soins {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String medicament;

    @OneToOne
    private Consultation consultation;

    public Soins() {
    }

    public Soins(String medicament) {
        this.medicament = medicament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    @Override
    public String toString() {
        return "Soins{" +
                "id=" + id +
                ", medicament='" + medicament + '\'' +
                ", consultation=" + consultation +
                '}';
    }
}
