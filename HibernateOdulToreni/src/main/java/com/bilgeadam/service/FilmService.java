package com.bilgeadam.service;

import com.bilgeadam.entity.*;

import com.bilgeadam.repository.FilmDao;


import java.util.Arrays;

public class FilmService {

    public static void main(String[] args) {
        save();
        //update();
        //getAll();
        //delete(1);

    }

    static FilmDao filmDao = new FilmDao();

    public static void save(){

        Actor actor1 = new Actor("Tom","Cruise");
        Actor actor2 = new Actor("Rebecca","Ferguson");
        Actor actor3 = new Actor("Simon","Pegg");

        Category category1 = new Category("Aksiyon");
        Director director1 = new Director( "Christopher", "McQuarrie");
        Award award1 = new Award("En İyi Aksiyon Filmi");
        Film film1 = new Film( "Mission İmpossible", award1, director1, Arrays.asList(actor1,actor2,actor3), category1);
        try {
            filmDao.save(film1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void getAll(){
        try{
            filmDao.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void update(){
        try {
            Actor actor1 = new Actor("Angelina","Jolie");
            Actor actor2 = new Actor("Liev","Schreiber");
            Actor actor3 = new Actor("Chiwetel ","Ejiofor");

            Category category1 = new Category("Aksiyon");
            Director director1 = new Director( "Philip", "Noyce");
            Award award1 = new Award("En İyi Aksiyon Filmi");
            Film film1 = new Film( 1,"Ajan Salt", award1, director1, Arrays.asList(actor1,actor2,actor3), category1);
            filmDao.update(film1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void delete(int id){
        filmDao.delete(id);
    }
}
