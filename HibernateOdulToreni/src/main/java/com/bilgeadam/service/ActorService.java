package com.bilgeadam.service;

import com.bilgeadam.entity.*;
import com.bilgeadam.repository.ActorDao;

import java.util.Arrays;

public class ActorService {

    public static void main(String[] args) {

        //save();
        //getAll();
        //delete(3);
        //update();
        getByFilmName("Joy");
    }

    static ActorDao actorDao= new ActorDao();

    public static void save(){

        Category category1 = new Category("Dram");
        Director director1 = new Director( "Roman" ,  "Polanski");
        Film film1 = new Film("Pianist", director1, category1);
        Award award1 = new Award("En İyi Erkek Oyuncu");
        Actor actor1 = new Actor("Adrien", "Brody", Arrays.asList(film1),award1);

        //Category category3 = new Category("Dram");
        //Director director3 = new Director( "Roman" ,  "Polanski");
        //Film film3 = new Film("Pianist", director3, category3);
        //Award award3 = new Award("En İyi Erkek Oyuncu");
        Actor actor3 = new Actor("Thomas ", "Kretschmann", Arrays.asList(film1));

        Category category2 = new Category("Komedi-Drama");
        Director director2 = new Director( "David O. " ,  "Russell");
        Film film2 = new Film("Joy", director2, category2);
        Award award2 = new Award("En İyi Kadın Oyuncu");
        Actor actor2 = new Actor("Jennifer ", "Lawrence", Arrays.asList(film2),award2);

        //Category category4 = new Category("Komedi-Drama");
        //Director director4 = new Director( "Jennifer" ,  "Lawrence");
        //Film film4 = new Film("Pianist", director2, category2);
        //Award award4 = new Award("En İyi Kadın Oyuncu");
        Actor actor4 = new Actor("Bradley ", "Cooper",  Arrays.asList(film2));
        try {
            //actorDao.save(actor1);
            // actorDao.save(actor3);
            actorDao.save(actor2);
            //actorDao.save(actor4);
            getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void getAll(){
        try{
            actorDao.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void update(){
        try {
            Category category2 = new Category("Komedi-Drama");
            Director director2 = new Director( "David O. " ,  "Russell");
            Film film2 = new Film("Joy", director2, category2);
            Award award2 = new Award("En İyi Kadın Oyuncu");
            Actor actor2 = new Actor(5,"Virginia ", "Madsen", Arrays.asList(film2),award2);
            actorDao.update(actor2);
            getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void delete(int id){
        actorDao.delete(id);
        getAll();
    }
    public static void getByFilmName(String word){
        try {
            actorDao.getByName(word);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
