package pro.ivashchuk.moviesadvisor.domain;

public class Movie {
    private Long id;
    private String movieName;
    private int ranking;

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
