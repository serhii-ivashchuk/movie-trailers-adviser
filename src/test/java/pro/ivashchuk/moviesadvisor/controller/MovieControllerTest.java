package pro.ivashchuk.moviesadvisor.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMovieControllerReturnsAllMoviesPageView() throws Exception{
        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(view().name("All_Movies"))
                .andExpect(content().string(containsString("All Movies")));
    }

    @Test
    public void testMovieControllerReturnsAddNewMoviePageView() throws Exception{
        mockMvc.perform(get("/movies/addNewMovie"))
                .andExpect(status().isOk())
                .andExpect(view().name("Add_New_Movie"))
                .andExpect(content().string(containsString("Let's add new movie!")));
    }

//    All Movies!
}