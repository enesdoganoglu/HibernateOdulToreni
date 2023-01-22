package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String filmName;

    @OneToOne(cascade = CascadeType.ALL)
    private Award award;

    @OneToOne(cascade = CascadeType.ALL)
    private Director director;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Actor> actors;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    public Film(Integer id, String filmName, Award award, Director director, List<Actor> actors, Category category) {
        this.id = id;
        this.filmName = filmName;
        this.award = award;
        this.director = director;
        this.actors = actors;
        this.category = category;
    }

    public Film(String filmName, Award award, Director director, List<Actor> actors, Category category) {
        this.filmName = filmName;
        this.award = award;
        this.director = director;
        this.actors = actors;
        this.category = category;
    }

    public Film(Integer id, String filmName, Director director, Category category) {
        this.id = id;
        this.filmName = filmName;
        this.director = director;
        this.category = category;
    }

    public Film(String filmName, Director director, Category category) {
        this.filmName = filmName;
        this.director = director;
        this.category = category;
    }

    public Film(Integer id, String filmName, Category category) {
        this.id = id;
        this.filmName = filmName;
        this.category = category;
    }

    public Film(String filmName, Category category) {
        this.filmName = filmName;
        this.category = category;
    }
}
