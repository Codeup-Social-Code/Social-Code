package dev.socialcode.socialcode.controllers;


import dev.socialcode.socialcode.daos.*;
import dev.socialcode.socialcode.models.*;
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
    private CommentsRepository commentsDao;
    private RSVPsRepository rsvpsDao;

    public PostController(PostRepository postRepository, CategoriesRepository categoriesRepository, UserRepository userRepository, CommentsRepository commentsRepository, RSVPsRepository rsvpsRepository) {
        this.postsDao = postRepository;
        this.categoriesDao = categoriesRepository;
        this.usersDao = userRepository;
        this.commentsDao = commentsRepository;
        this.rsvpsDao = rsvpsRepository;
    }

    @GetMapping("/posts/create")
    public String showForm(Model viewModel) {
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }

//    Single Post View
    @GetMapping("/posts/{id}")
    public String showOne(@PathVariable long id, Model model) {
        Post post = postsDao.getOne(id);
        List<Comment> comments = commentsDao.findCommentsByPostId(id);
        List<RSVP> rsvps = rsvpsDao.findRSVPSByPostId(id);
        System.out.println("RSVP ID: " + rsvps);
        model.addAttribute("rsvps", rsvps);
        model.addAttribute("comment", new Comment());
        model.addAttribute("post", post);
        model.addAttribute("No Comments", comments.size() == 0);
        model.addAttribute("comments", comments);
        return "posts/show";
    }


    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post postToBeSaved, @RequestParam(name = "category") String catId) {

        System.out.println(postToBeSaved.getEventTime());
        System.out.println(postToBeSaved.getEvent_start());
        System.out.println(postToBeSaved.getEvent_end());

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
        return "redirect:/posts";
    }

    //update functionality will be added once user authentication is setup


    @GetMapping("/posts/{id}/edit")
    public String showEditForm(Model model, @PathVariable long id) {
        //find an ad
        Post postToEdit = postsDao.getOne(id);
        model.addAttribute("post", postToEdit);
        return "posts/edit";
    }

    //Update Post
    @PostMapping("/posts/edit")
    public String update(@ModelAttribute Post postEdited) {
        Post postToBeUpdated = postsDao.getOne(postEdited.getId());
        postToBeUpdated.setTitle(postEdited.getTitle());
        postToBeUpdated.setBody(postEdited.getBody());
        postsDao.save(postToBeUpdated);
        return "redirect:/posts/" + postEdited.getId();
    }

//    USING THE FOLLOWING TO BUILD COMMUNITY PAGE

    @GetMapping("/posts")
    public String viewPosts(Model model) {
//        User user = usersDao.findByUsername("test2@gmail.com");
//        System.out.println(user.getFirstName());
        List<Post> currentPosts = postsDao.findTop9ByOrderByIdDesc();
        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("posts", currentPosts);
        return "posts/index";
    }

//    @GetMapping("/mapbox")
//    public String viewMapbox(Model model) {
//        return "posts/mapbox";
//    }
//
//    @GetMapping("/users.json")
//    public @ResponseBody List<User> viewAllUserInJSONFormat() {
//        return usersDao.findAll();
//    }

//    @GetMapping("/posts/ajax")
//    public String viewAllAdsWithAjax() {
//        return "ads/ajax";
//    }

    @GetMapping("/calendar")
    public String viewCalendar() {
        return "posts/calendar";
    }

    @GetMapping("/posts.json")
    public @ResponseBody List<Post> viewAllPostsWithAjax() {
        return postsDao.findAll();
    }


}
