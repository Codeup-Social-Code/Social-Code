package dev.socialcode.socialcode.controllers;


import dev.socialcode.socialcode.daos.PostsRepository;
import dev.socialcode.socialcode.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private PostsRepository postsDao;

    public PostController(PostsRepository postsRepository) {
        this.postsDao = postsRepository;
    }

    @GetMapping("/posts/create")
    public String showForm(Model viewModel) {
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post postToBeSaved, @RequestParam(name = "category") String category) {
        System.out.println(postToBeSaved.getEventTime());
        System.out.println(postToBeSaved.getEventDate());
        return "/posts/index";
    }


}
