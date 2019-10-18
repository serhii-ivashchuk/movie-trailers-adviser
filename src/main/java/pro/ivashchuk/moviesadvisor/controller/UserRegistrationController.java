package pro.ivashchuk.moviesadvisor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.ivashchuk.moviesadvisor.domain.User;
import pro.ivashchuk.moviesadvisor.repository.JpaUserRepository;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    @GetMapping("/registration")
    public String userRegistration(Model model){
        model.addAttribute("user", new User());
        return "Add_New_User";
    }
}
