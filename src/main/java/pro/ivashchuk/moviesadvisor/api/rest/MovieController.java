package pro.ivashchuk.moviesadvisor.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping
    public Movie getMovieById(@PathVariable("id") Long id){
        return jpaMovieRepository.findById(id).get();
    }
}
