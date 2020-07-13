package dev.socialcode.socialcode.controllers;

import dev.socialcode.socialcode.daos.UserRepository;
import dev.socialcode.socialcode.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepository usersDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository usersDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersDao.save(user);
        return "redirect:/login";
        //redirects go to urls, not to files
    }

    //get single user view
    @GetMapping("/users/{id}")
    public String getUser(@PathVariable long id, Model model) {
        User user = usersDao.getOne(id);
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        return "users/user";


        //also I changed the UserRepository instance from users
        // to usersDao for clarity

        //what other controllers do we need?

    }

}