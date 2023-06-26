package example.services;

import example.entities.Patient;
import example.entities.Soins;
import example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class SoinsService extends BaseService implements Repository<Soins> {

    public SoinsService() {
        super();
    }


    @Override
    public boolean create(Soins o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Soins o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Soins o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Soins findById(int id) {
        Soins soins = null;
        session = sessionFactory.openSession();
        soins = (Soins) session.get(Soins.class, id);
        session.close();
        return soins;
    }

    @Override
    public List<Soins> findAll() {
        List<Soins> soinsList = null;
        session = sessionFactory.openSession();
        Query<Soins> soinsQuery = session.createQuery("from Soins");
        soinsList = soinsQuery.list();
        session.close();
        return soinsList;
    }
}
