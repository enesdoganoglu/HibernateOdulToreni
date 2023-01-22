package com.bilgeadam.service;

import com.bilgeadam.entity.*;
import com.bilgeadam.repository.DirectorDao;
import com.bilgeadam.repository.FilmDao;

import java.util.Arrays;

public class DirectorService {

    public static void main(String[] args) {
        //save();
        update();
        //getAll();
        //delete(10);

    }

    static DirectorDao directorDao = new DirectorDao();

    public static void save(){


        Category category1 = new Category("Aksiyon");

        Film film1 = new Film("Jack Reacher",category1);
        Film film2 = new Film("Top Gun",category1);
        Award award8 = new Award("En İyi Yönetmen");
        Director director1 = new Director("Christopher","McQuarrie", Arrays.asList(film1,film2),  award8);
        try {
            directorDao.save(director1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void getAll(){
        try{
            directorDao.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void update(){
        try {
            Category category1 = new Category("Aksiyon");
            Film film1 = new Film("Yarının Sınırında",category1);
            Film film2 = new Film("Mumya",category1);
            Award award8 = new Award("En İyi Yönetmen");
            Director director1 = new Director(11,"David","McQuarrie", Arrays.asList(film1,film2),  award8);
            directorDao.update(director1);
            getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void delete(int id){
        directorDao.delete(id);
        getAll();
    }
}
