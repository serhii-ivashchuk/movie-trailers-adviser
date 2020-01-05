package pro.ivashchuk.moviesadvisor.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String picture;

    @Lob
    @Column(name="image")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] image;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<Movie> getPlayedMovies() {
        return playedMovies;
    }

    public void setPlayedMovies(Set<Movie> playedMovies) {
        this.playedMovies = playedMovies;
    }

    public void setMovieToPlayedMovies(Movie movie) {
        this.playedMovies.add(movie);
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