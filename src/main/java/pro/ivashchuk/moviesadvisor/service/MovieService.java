package pro.ivashchuk.moviesadvisor.service;

import pro.ivashchuk.moviesadvisor.domain.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    void addMovie(Movie movie);
    void updateMovie(Movie movie);
}