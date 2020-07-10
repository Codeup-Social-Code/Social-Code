package dev.socialcode.socialcode.controllers;


import dev.socialcode.socialcode.daos.CategoriesRepository;
import dev.socialcode.socialcode.daos.PostsRepository;
import dev.socialcode.socialcode.models.Category;
import dev.socialcode.socialcode.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    private PostsRepository postsDao;
    private CategoriesRepository categoriesDao;

    public PostController(PostsRepository postsRepository, CategoriesRepository categoriesRepository) {
        this.postsDao = postsRepository;
        this.categoriesDao = categoriesRepository;
    }

    @GetMapping("/posts/create")
    public String showForm(Model viewModel) {
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post postToBeSaved, @RequestParam(name = "category") String catId) {

        System.out.println(postToBeSaved.getEventTime());
        System.out.println(postToBeSaved.getEventDate());

        Category category = categoriesDao.findCategoryById(Long.parseLong(catId));
        List<Category> listOfCategories = new ArrayList<>();
        listOfCategories.add(category);
        postToBeSaved.setCategories(listOfCategories);

        Date curDate = new Date();
        postToBeSaved.setCreateDate(curDate);
        postsDao.save(postToBeSaved);
        return "/posts/index";
    }



}
