package pro.ivashchuk.moviesadvisor.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.ivashchuk.moviesadvisor.domain.Movie;
import pro.ivashchuk.moviesadvisor.repository.JpaMovieRepository;
import pro.ivashchuk.moviesadvisor.service.MovieServiceImpl;

import java.util.List;

@RestController("RestMovieController")
@RequestMapping(path = "/api/movies", produces = "application/json")
public class MovieController {

    private JpaMovieRepository jpaMovieRepository;

    private MovieServiceImpl movieServiceImpl;

    public MovieController(JpaMovieRepository jpaMovieRepository, MovieServiceImpl movieServiceImpl) {
        this.jpaMovieRepository = jpaMovieRepository;
        this.movieServiceImpl = movieServiceImpl;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return jpaMovieRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Movie getMovieById(@PathVariable("id") Long id) {
        return jpaMovieRepository.findById(id).get();
    }

    @PostMapping(path = "/addNewMovie", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie addNewMovie(@RequestBody Movie movie) {
        return jpaMovieRepository.save(movie);
    }
}
