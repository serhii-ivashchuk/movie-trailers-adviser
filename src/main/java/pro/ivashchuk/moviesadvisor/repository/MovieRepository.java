package pro.ivashchuk.moviesadvisor.repository;

import pro.ivashchuk.moviesadvisor.domain.Movie;

public interface MovieRepository {
    Iterable<Movie> findAll();
}
