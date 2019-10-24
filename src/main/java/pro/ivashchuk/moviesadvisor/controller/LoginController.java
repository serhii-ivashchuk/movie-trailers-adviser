package pro.ivashchuk.moviesadvisor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String returnLoginPage(){
        System.out.println("returnLoginPage() of LoginController is invoked");
        return "login";
    }
}
