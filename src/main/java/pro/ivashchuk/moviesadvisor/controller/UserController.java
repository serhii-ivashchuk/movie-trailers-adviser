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

    @GetMapping("/registration")
    public String addNewUser(Model model) {
        model.addAttribute("user", new UserRegistrationForm());
        log.info("userRegistration() of UserRegistrationController is invoked");
        return "Add_New_User";
    }

    @PostMapping("/registration")
    public String processNewUser(@Valid UserRegistrationForm user) {
        jpaUserRepository.save(user.toUser(passwordEncoder));
        log.info("processNewUser of UserRegistrationController is invoked");
        log.info("User: " + user);
        return "redirect:/";
    }
}
