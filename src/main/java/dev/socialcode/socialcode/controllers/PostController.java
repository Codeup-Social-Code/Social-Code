package dev.socialcode.socialcode.controllers;


import dev.socialcode.socialcode.daos.CategoriesRepository;
import dev.socialcode.socialcode.daos.PostRepository;
import dev.socialcode.socialcode.daos.UserRepository;
import dev.socialcode.socialcode.models.Category;
import dev.socialcode.socialcode.models.Post;
import dev.socialcode.socialcode.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
//import java.sql.Date; -- we need to change to this
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    private PostRepository postsDao;
    private CategoriesRepository categoriesDao;
    private UserRepository usersDao;

    public PostController(PostRepository postRepository, CategoriesRepository categoriesRepository, UserRepository userRepository) {
        this.postsDao = postRepository;
        this.categoriesDao = categoriesRepository;
        this.usersDao = userRepository;
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

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(currentUser);
        postToBeSaved.setUser(currentUser);

        Category category = categoriesDao.findCategoryById(Long.parseLong(catId));
        List<Category> listOfCategories = new ArrayList<>();
        listOfCategories.add(category);
        postToBeSaved.setCategories(listOfCategories);

        Date curDate = new Date();
        postToBeSaved.setCreateDate(curDate);
        postsDao.save(postToBeSaved);
        return "posts/index";
    }

//    USING THE FOLLOWING TO BUILD COMMUNITY PAGE

    @GetMapping("/posts")
    public String viewPosts() {
        User user = usersDao.findByUsername("test2@gmail.com");
        System.out.println(user.getFirstName());
        return "posts/index";
    }


}
