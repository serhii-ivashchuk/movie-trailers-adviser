package pro.ivashchuk.moviesadvisor.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.ivashchuk.moviesadvisor.domain.Movie;
import pro.ivashchuk.moviesadvisor.domain.User;
import pro.ivashchuk.moviesadvisor.repository.JpaMovieRepository;

import java.util.List;

@RestController("RestMovieController")
@RequestMapping(path="/api/movies", produces = "application/json")
public class MovieController {

    private JpaMovieRepository jpaMovieRepository;

    public MovieController(JpaMovieRepository jpaMovieRepository) {
        this.jpaMovieRepository = jpaMovieRepository;
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return jpaMovieRepository.findAll();
    }
}
