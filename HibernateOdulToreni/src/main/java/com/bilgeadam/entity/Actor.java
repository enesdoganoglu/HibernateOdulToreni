package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String actorFirstName;
    private String actorLastName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Film> film;

    @OneToOne(cascade = CascadeType.ALL)
    private Award award;

    public Actor(String actorFirstName, String actorLastName) {
        this.actorFirstName = actorFirstName;
        this.actorLastName = actorLastName;
    }

    public Actor(Integer id, String actorFirstName, String actorLastName, List<Film> film, Award award) {
        this.id = id;
        this.actorFirstName = actorFirstName;
        this.actorLastName = actorLastName;
        this.film = film;
        this.award = award;
    }

    public Actor(String actorFirstName, String actorLastName, List<Film> film, Award award) {
        this.actorFirstName = actorFirstName;
        this.actorLastName = actorLastName;
        this.film = film;
        this.award = award;
    }

    public Actor(Integer id, String actorFirstName, String actorLastName, List<Film> film) {
        this.id = id;
        this.actorFirstName = actorFirstName;
        this.actorLastName = actorLastName;
        this.film = film;
    }

    public Actor(String actorFirstName, String actorLastName, List<Film> film) {
        this.actorFirstName = actorFirstName;
        this.actorLastName = actorLastName;
        this.film = film;
    }
}
