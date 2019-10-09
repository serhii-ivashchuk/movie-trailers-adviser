package pro.ivashchuk.moviesadvisor.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    private Long id;
    private String movieName;
    private int ranking;

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

    public Movie() {
    }

    public Movie(Long id, String movieName, int ranking) {
        this.id = id;
        this.movieName = movieName;
        this.ranking = ranking;
    }

    public Movie(String movieName, int ranking) {
        this.movieName = movieName;
        this.ranking = ranking;
    }
}
