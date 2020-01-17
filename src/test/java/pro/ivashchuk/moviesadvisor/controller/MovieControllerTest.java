package pro.ivashchuk.moviesadvisor.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pro.ivashchuk.moviesadvisor.domain.Movie;
import pro.ivashchuk.moviesadvisor.repository.JpaMovieRepository;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    JpaMovieRepository jpaMovieRepository;

    Movie movie;

    @Before
    public void setUp() {
        movie = new Movie(1L, "Green Mile", 10, "Green Mile.jpg", "youtube.com/watch?v=Ki4haFrqSrw");
    }


    @Test
    public void testMovieControllerReturnsAllMoviesPageView() throws Exception{
        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(view().name("All_Movies"))
                .andExpect(content().string(containsString("All Movies")));
    }

    @Test
    public void testMovieControllerReturnsAddNewMoviePageView() throws Exception {
        mockMvc.perform(get("/movies/addNewMovie"))
                .andExpect(status().isOk())
                .andExpect(view().name("Add_New_Movie"))
                .andExpect(content().string(containsString("Let's add new movie!")));
    }

    @Test
    public void testMovieControllerReturnsMoviePageView() throws Exception {
        jpaMovieRepository.save(movie);
        mockMvc.perform(get("/movies/Movie/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("Movie"))
                .andExpect(content().string(containsString("Movie page")));
    }

//    All Movies!
}