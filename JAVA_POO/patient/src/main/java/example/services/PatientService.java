package example.services;

import example.entities.Patient;
import example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class PatientService extends BaseService implements Repository<Patient> {

    public PatientService() {
        super();
    }


    @Override
    public boolean create(Patient o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Patient o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Patient o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Patient findById(int id) {
        Patient patient = null;
        session = sessionFactory.openSession();
        patient = (Patient) session.get(Patient.class, id);
        session.close();
        return patient;
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patientList = null;
        session = sessionFactory.openSession();
        Query<Patient> patientQuery = session.createQuery("from Patient");
        patientList = patientQuery.list();
        session.close();
        return patientList;
    }

    public List<Patient> findByName(String valeur) {
        List<Patient> patientList = null;
        session = sessionFactory.openSession();
        Query<Patient> patientQuery = session.createQuery("from Patient WHERE nom = :valeur ");
        patientQuery.setParameter("valeur" , valeur);
        patientList = patientQuery.list();
        session.close();
        return patientList;
    }
}
