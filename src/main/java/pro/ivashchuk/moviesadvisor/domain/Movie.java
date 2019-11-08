package pro.ivashchuk.moviesadvisor.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank(message="Movie Name is required")
    private String movieName;

    private int ranking;

    private String poster;

    private String youtubeLink;

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

    public Movie() {
    }

    public Movie(Long id, String movieName, int ranking, String poster) {
        this.id = id;
        this.movieName = movieName;
        this.ranking = ranking;
        this.poster = poster;
    }

    public Movie(String movieName, int ranking) {
        this.movieName = movieName;
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return String.format(
                "Movie id[id=%d, movieName='%s', movieRanking='%d', poster='%s']",
                id, movieName, ranking, poster);
    }
}
