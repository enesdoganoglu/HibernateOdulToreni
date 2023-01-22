package com.bilgeadam.repository;


import com.bilgeadam.entity.Actor;
import com.bilgeadam.entity.Director;
import com.bilgeadam.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class DirectorDao {

    public void save(Director director){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(director);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void getAll() {
        List<Object[]> directorList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select d.id,d.directorFirstName,d.directorLastName,aw.awardName,f.filmName from director as d\n" +
                    "inner join director_film as df on df.Director_id = d.id\n" +
                    "inner join film  as f on df.film_id = f.id\n" +
                    "inner join category as c on c.id = f.category_id\n" +
                    "inner join award as aw on aw.id = d.award_id";
            directorList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : directorList) {
                System.out.println(" ID: " + item[0] + " --"
                        +"DirectorFirstName: " + item[1] + " --"
                        + " DirectorLastName: " + item[2] + " --"
                        + " AwardName: " + item[3] + "-- "
                        + " FilmName: " + item[4]


                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void update(Director director) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(director);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Session session = null;
        Director director = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            director = session.load(Director.class, id);
            session.delete(director);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
}
