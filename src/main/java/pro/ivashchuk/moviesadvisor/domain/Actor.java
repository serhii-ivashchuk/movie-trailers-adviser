package pro.ivashchuk.moviesadvisor.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String picture;

    @ManyToMany(mappedBy = "movieActors")
    Set<Movie> playedMovies;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Actor() {
    }

    public Actor(Long id, String name, String surname, String picture) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.picture = picture;
    }

    public Actor(String name, String surname,  String picture) {
        this.name = name;
        this.surname = surname;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return String.format(
                "Actor id[id=%d, name='%s', surname='%s'", id, name, surname);
    }
}