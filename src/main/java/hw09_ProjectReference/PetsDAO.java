package hw09_ProjectReference;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PetsDAO implements CrudOperaion<Pets> {

private final SessionFactory sessionFactory;

private Map<Integer, SoftReference<Pets>> cachePets = new HashMap<Integer,SoftReference<Pets>>();

PetsDAO(){
    sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

}


    @Override
    public Pets save(Pets obj) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(obj);
            transaction.commit();
            return obj;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return obj;
    }


    @Override
    public void deleteById(int id) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Pets WHERE id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByEntity(Pets obj) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Pets WHERE id = :id")
                    .setParameter("id", obj.getId())
                    .executeUpdate();
            transaction.commit();
            obj = null;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void deleteAll() {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Pets").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public Pets update(Pets obj) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(obj);
            transaction.commit();
            return obj;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public Pets getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Pets pets = session.get(Pets.class, id);

            return pets;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pets cacheGetById(int id) {

    if(cachePets.containsKey(id))
    {
        return cachePets.get(id).get();

    }
        try (Session session = sessionFactory.openSession()) {
            Pets pets = session.get(Pets.class, id);
            cachePets.put(pets.getId(),new SoftReference<Pets>(pets));
            return pets;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Pets> getAll() {
        Transaction transaction = null;
        List<Pets> pets;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            pets = session.createQuery("FROM Pets", Pets.class).list();
            transaction.commit();

            return pets;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return null;
    }
}
