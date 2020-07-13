package dev.socialcode.socialcode.controllers;

import dev.socialcode.socialcode.daos.UserRepository;
import dev.socialcode.socialcode.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    private UserRepository usersDao;
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginForm(){
    return "users/login";
}


//    @GetMapping("/sign-up")
//    public String showSignupForm(Model model) {
//        model.addAttribute("user", new User());
//        return "users/sign-up";
//    }
}
