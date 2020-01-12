package pro.ivashchuk.moviesadvisor.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank(message="Movie Name is required")
    private String movieName;
    private int year;
    private int ranking;

    private String poster;

    private String youtubeLink;

    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    Set<Actor> movieActors;

    @ManyToMany
    @JoinTable(
            name = "movie_user",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> movieUserCommitters = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public Set<User> getMovieUserCommitters() {
        return movieUserCommitters;
    }

    public void setMovieUserCommitters(Set<User> movieUserCommitters) {
        this.movieUserCommitters = movieUserCommitters;
    }

    public Movie() {
    }

    public Movie(Long id, String movieName, int ranking, String poster, String youtubeLink) {
        this.id = id;
        this.movieName = movieName;
        this.ranking = ranking;
        this.poster = poster;
        this.youtubeLink = youtubeLink;
    }

    public Movie(String movieName, int ranking) {
        this.movieName = movieName;
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return String.format(
                "Movie id[id=%d, movieName='%s', movieRanking='%d', poster='%s', youtubeLink='%s]",
                id, movieName, ranking, poster, youtubeLink);
    }
}
