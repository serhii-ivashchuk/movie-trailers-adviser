package pro.ivashchuk.moviesadvisor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = jpaUserRepository.findAll();
        model.addAttribute("users", users);
        return "All_Users";
    }

    @GetMapping("/user")
    public String getUser() {
        return "User";
    }
}
