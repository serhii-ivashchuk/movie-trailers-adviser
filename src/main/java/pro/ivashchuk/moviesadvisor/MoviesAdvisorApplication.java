package pro.ivashchuk.moviesadvisor;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@EnableAutoConfiguration
@SpringBootApplication
public class MoviesAdvisorApplication {

    public static void main(String[] args) {
    SpringApplication.run(MoviesAdvisorApplication.class, args);
}
}
