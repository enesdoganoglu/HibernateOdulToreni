package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String directorFirstName;
    private String directorLastName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Film> film;

    @OneToOne(cascade = CascadeType.ALL)
    private Award award;

    public Director(String directorFirstName, String directorLastName) {
        this.directorFirstName = directorFirstName;
        this.directorLastName = directorLastName;
    }

    public Director(Integer id, String directorFirstName, String directorLastName, List<Film> film, Award award) {
        this.id = id;
        this.directorFirstName = directorFirstName;
        this.directorLastName = directorLastName;
        this.film = film;
        this.award = award;
    }

    public Director(String directorFirstName, String directorLastName, List<Film> film, Award award) {
        this.directorFirstName = directorFirstName;
        this.directorLastName = directorLastName;
        this.film = film;
        this.award = award;
    }
}
