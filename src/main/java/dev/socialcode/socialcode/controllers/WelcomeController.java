package dev.socialcode.socialcode.controllers;

import dev.socialcode.socialcode.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/users/welcome")
    public String showForm(Model viewModel) {
        viewModel.addAttribute("post", new Post());
        return "users/welcome";
    }
}
