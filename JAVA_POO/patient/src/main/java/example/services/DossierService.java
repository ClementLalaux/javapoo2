package example.services;

import example.entities.Dossier;
import example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class DossierService extends BaseService implements Repository<Dossier> {

    public DossierService() {
        super();
    }


    @Override
    public boolean create(Dossier o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Dossier o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Dossier o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Dossier findById(int id) {
        Dossier dossier = null;
        session = sessionFactory.openSession();
        dossier = (Dossier) session.get(Dossier.class, id);
        session.close();
        return dossier;
    }

    @Override
    public List<Dossier> findAll() {
        List<Dossier> dossierList = null;
        session = sessionFactory.openSession();
        Query<Dossier> dossierQuery = session.createQuery("from Dossier");
        dossierList = dossierQuery.list();
        session.close();
        return dossierList;
    }
}
