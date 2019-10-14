package pro.ivashchuk.moviesadvisor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.ivashchuk.moviesadvisor.domain.Movie;
import pro.ivashchuk.moviesadvisor.repository.JpaMovieRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private JpaMovieRepository jpaMovieRepository;

    public MovieController(JpaMovieRepository jpaMovieRepository) {
        this.jpaMovieRepository = jpaMovieRepository;
    }


    @GetMapping
    public String getAllMovies(Model model) {
        List<Movie> movies = new ArrayList<>(jpaMovieRepository.findAll());
        model.addAttribute("movies", movies);
        return "All_Movies";
    }

    @GetMapping("/Movie")
    public String getMovieById() {
        return "Movie";
    }

    @GetMapping("/addNewMovie")
    public String addNewMovie(Model model) {
        model.addAttribute(new Movie());
        return "Add_New_Movie";
    }

    @PostMapping("/addNewMovie")
    public String processNewMovie(@Valid Movie movie) {
        jpaMovieRepository.save(movie);
        return "redirect:/";
    }
}
