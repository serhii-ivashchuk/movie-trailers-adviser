package pro.ivashchuk.moviesadvisor.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ActorController.class)
public class ActorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testActorControllerReturnsAllActorsPageView() throws Exception {
        mockMvc.perform(get("/actors"))
                .andExpect(status().isOk())
                .andExpect(view().name("All_Actors"))
                .andExpect(content().string(containsString("All Actors")));
    }
}