package com.bilgeadam.repository;

import com.bilgeadam.entity.Film;
import org.hibernate.Session;
import com.bilgeadam.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class FilmDao {

    public void save(Film film){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(film);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void getAll() {
        List<Object[]> filmList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select f.filmName, ac.actorFirstName,ac.actorLastName,aw.awardName,c.categoryName,d.directorFirstName,d.directorLastName from film as f\n" +
                    "inner join  award as aw on f.award_id = aw.id\n" +
                    "inner join category as c on f.category_id = c.id\n" +
                    "inner join director as d on f.director_id = d.id\n" +
                    "inner join film_actor as fa on f.id = fa.film_id\n" +
                    "inner join actor as ac on ac.id = fa.actors_id";
            filmList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : filmList) {
                System.out.println("FilmName: " + item[0] + " --"
                        + " ActorFirstName: " + item[1] + " --"
                        + " ActorLastName: " + item[2] + "-- "
                        + " AwardName: " + item[3] + " --"
                        + " CategoryName: " + item[4] + " --"
                        + " DirectorFirstName: " + item[5]+ " --"
                        + " DirectorLastName: " + item[6]

                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void update(Film film) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(film);
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
        Film film = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            film = session.load(Film.class, id);
            session.delete(film);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }




}
