package dev.socialcode.socialcode.controllers;

import dev.socialcode.socialcode.daos.PostsRepository;
import dev.socialcode.socialcode.models.Post;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PostController {

    private PostsRepository postsDao;

    public PostController(PostsRepository postsRepository) {
        this.postsDao = postsRepository;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showForm(Model viewModel) {
        viewModel.addAttribute("post", new Post());
        return "This wil be the create form";
    }


}
