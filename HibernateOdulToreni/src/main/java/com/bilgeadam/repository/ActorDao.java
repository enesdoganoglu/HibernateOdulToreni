package com.bilgeadam.repository;

import com.bilgeadam.entity.Actor;
import com.bilgeadam.entity.Film;
import com.bilgeadam.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ActorDao {

    public void save(Actor actor){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(actor);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void getAll() {
        List<Object[]> actorList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select ac.id,ac.actorFirstName,ac.actorLastName,f.filmName,aw.awardName  from actor as ac\n" +
                    "inner join  award as aw on ac.award_id = aw.id\n" +
                    "inner join  actor_film as af on af.Actor_id = ac.id\n" +
                    "inner join film as f on f.id = af.film_id\n" +
                    "inner join category as c on f.category_id = c.id\n" +
                    "inner join director as d on f.director_id = d.id";
            actorList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : actorList) {
                System.out.println(" ID: " + item[0] + " --"
                        +"ActorFirstName: " + item[1] + " --"
                        + " ActorLastName: " + item[2] + " --"
                        + " FilmName: " + item[3] + "-- "
                        + " AwardName: " + item[4]


                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void update(Actor actor) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(actor);
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
        Actor actor = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            actor = session.load(Actor.class, id);
            session.delete(actor);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
    public void getByName(String word) {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        String sql = "select ac.id,ac.actorFirstName,ac.actorLastName,f.filmName,aw.awardName  from actor as ac\n" +
                "inner join  award as aw on ac.award_id = aw.id\n" +
                "inner join  actor_film as af on af.Actor_id = ac.id\n" +
                "inner join film as f on f.id = af.film_id\n" +
                "inner join category as c on f.category_id = c.id\n" +
                "inner join director as d on f.director_id = d.id where f.filmName like ?";
        try {
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter(1, "%" + word + "%");
            List<Object[]> array = query.getResultList();
            for (Object[] item : array) {
                System.out.println(" ID: " + item[0] + " --"
                        +"ActorFirstName: " + item[1] + " --"
                        + " ActorLastName: " + item[2] + " --"
                        + " FilmName: " + item[3] + "-- "
                        + " AwardName: " + item[4]
                );
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
