package example.services;


import example.entities.Patient;
import example.entities.Prescription;
import example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class PrescriptionService extends BaseService implements Repository<Prescription> {

    public PrescriptionService() {
        super();
    }


    @Override
    public boolean create(Prescription o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Prescription o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Prescription o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Prescription findById(int id) {
        Prescription prescription = null;
        session = sessionFactory.openSession();
        prescription = (Prescription) session.get(Prescription.class, id);
        session.close();
        return prescription;
    }

    @Override
    public List<Prescription> findAll() {
        List<Prescription> prescriptionList = null;
        session = sessionFactory.openSession();
        Query<Prescription> prescriptionQuery = session.createQuery("from Prescription");
        prescriptionList = prescriptionQuery.list();
        session.close();
        return prescriptionList;
    }
}
