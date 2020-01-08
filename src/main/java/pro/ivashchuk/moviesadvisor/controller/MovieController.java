package pro.ivashchuk.moviesadvisor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.ivashchuk.moviesadvisor.domain.Movie;
import pro.ivashchuk.moviesadvisor.repository.JpaMovieRepository;
import pro.ivashchuk.moviesadvisor.repository.JpaUserRepository;
import pro.ivashchuk.moviesadvisor.service.MovieServiceImpl;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    final static Logger log = LoggerFactory.getLogger(MovieController.class);

    private JpaMovieRepository jpaMovieRepository;
    private JpaUserRepository jpaUserRepository;

    private MovieServiceImpl movieServiceImpl;

    public MovieController(JpaMovieRepository jpaMovieRepository,
                           MovieServiceImpl movieServiceImpl, JpaUserRepository jpaUserRepository) {
        this.jpaMovieRepository = jpaMovieRepository;
        this.movieServiceImpl = movieServiceImpl;
        this.jpaUserRepository = jpaUserRepository;
    }

    @GetMapping
    public String getAllMovies(Model model) {
        log.info("getAllMovies() of MovieController is invoked");
        List<Movie> movies = new ArrayList<>(jpaMovieRepository.findAll());
        model.addAttribute("movies", movies);
        return "All_Movies";
    }

    @GetMapping("/addNewMovie")
    public String addNewMovie(Model model) {
        log.info("addNewMovie() of MovieController is invoked");
        model.addAttribute("movie", new Movie());
        return "Add_New_Movie";
    }

    @PostMapping("/addNewMovie")
    public String processNewMovie(@Valid Movie movie, @AuthenticationPrincipal String username) {
        log.info("processNewMovie (http post()) of MovieController is invoked");
        log.info("User: " + username);
        movie.setUserToMovieUserCommitters(jpaUserRepository.findByUsername(username));
        jpaMovieRepository.save(movie);
        log.info("processNewMovie()  jpaMovieRepository.save() is invoked");
        log.info("Movie: " + movie);
        return "redirect:/movies";
    }

    @GetMapping("/Movie/{id}")
    public String getMovieById(@PathVariable("id") Long id, Model model) {
        log.info("getMovieById() of MovieController is invoked");
        log.info("getMovieById() of MovieController is invoked");
        Movie movie = jpaMovieRepository.findById(id).get();
        log.info("movie " + movie);
        model.addAttribute("movie", movie);
        return "Movie";
    }

    @GetMapping("/Movie/{id}/patch")
    public String getMovieForPatchById(@PathVariable("id") Long id, Model model) {
        log.info("getMovieForPatchById() of MovieController is invoked");
        log.info("getMovieById() of MovieController is invoked");
        Movie patchMovie = jpaMovieRepository.findById(id).get();
        log.info("patchMovie " + patchMovie);
        model.addAttribute("patchMovie", patchMovie);
        return "Update_Movie";
    }

    @GetMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable("id") Long id, Model model) {
        jpaMovieRepository.delete(jpaMovieRepository.findById(id).get());
        return "redirect:/movies";
    }
}
