package pro.ivashchuk.moviesadvisor.api.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.ivashchuk.moviesadvisor.repository.JpaMovieRepository;

@RestController
@RequestMapping(path="/api/movies", produces = "application/json")
public class MovieController {
    private JpaMovieRepository jpaMovieRepository;

    public MovieController(JpaMovieRepository jpaMovieRepository) {
        this.jpaMovieRepository = jpaMovieRepository;
    }
}
