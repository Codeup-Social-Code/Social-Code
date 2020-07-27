package dev.socialcode.socialcode.controllers;


import dev.socialcode.socialcode.daos.*;
import dev.socialcode.socialcode.models.*;
import dev.socialcode.socialcode.services.UserService;
import javassist.Loader;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
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
    private UserService usersService;

    public PostController(PostRepository postRepository, CategoriesRepository categoriesRepository, UserRepository userRepository, CommentsRepository commentsRepository, RSVPsRepository rsvpsRepository, UserService usersService) {
        this.postsDao = postRepository;
        this.categoriesDao = categoriesRepository;
        this.usersDao = userRepository;
        this.commentsDao = commentsRepository;
        this.rsvpsDao = rsvpsRepository;
        this.usersService = usersService;
    }

    @GetMapping("/posts/create")
    public String showForm(Model viewModel) {
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }

    //Search Functionality
    @GetMapping("/search")
    public String showSearch(Model model, @RequestParam(name = "term") String term) {
        List<Category> categories = categoriesDao.searchByCategory(term);
        if(!categories.isEmpty()) {
            long newTerm = 0;
            for(Category category: categories) {
                newTerm = category.getId();
            }
            List<Post> posts = postsDao.searchByCategoryId(newTerm);
            model.addAttribute("posts", posts);
            return "posts/index";
        }

        List<Post> posts = postsDao.searchByTerm(term);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

//    Single Post View
    @GetMapping("/posts/{id}")
    public String showOne(@PathVariable long id, Model model) {
        Post post = postsDao.getOne(id);
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        List<Comment> comments = commentsDao.findCommentsByPostId(id);
        List<RSVP> rsvps = rsvpsDao.findRSVPSByPostId(id);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("rsvps", rsvps);
        model.addAttribute("comment", new Comment());
        model.addAttribute("post", post);
//        model.addAttribute("No Comments", comments.size() == 0);
//        model.addAttribute("comments", comments);
        return "posts/show";
    }


    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post postToBeSaved, @RequestParam(name = "category") String catId, Authentication authentication) {

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postToBeSaved.setUser(currentUser);
        Date dateStart;
        Date dateEnd;

        try {
            dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(postToBeSaved.getStart_date_time());
            dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse(postToBeSaved.getEnd_date_time());
            System.out.println(dateEnd);
            System.out.println(dateStart);
            String startDate = new SimpleDateFormat("yyyy-MM-dd").format(dateStart);
            String endDate = new SimpleDateFormat("yyyy-MM-dd").format(dateEnd);
            System.out.println(startDate);
            System.out.println(endDate);
            System.out.println(postToBeSaved.getStart_time());
            System.out.println(postToBeSaved.getEnd_time());
            String startFormat = startDate + 'T' +postToBeSaved.getStart_time();
            String endFormat = endDate + 'T' + postToBeSaved.getEnd_time();
            System.out.println(startFormat);
            System.out.println(endFormat);
            postToBeSaved.setStart_date_time(startFormat);
            postToBeSaved.setEnd_date_time(endFormat);
        } catch (ParseException e) {

        }

        Category category = categoriesDao.findCategoryById(Long.parseLong(catId));
        List<Category> listOfCategories = new ArrayList<>();
        listOfCategories.add(category);
        postToBeSaved.setCategories(listOfCategories);

        Date curDate = new Date();
        postToBeSaved.setCreateDate(curDate);
        postsDao.save(postToBeSaved);
        return "redirect:/posts";
    }

    @GetMapping("/calendar")
    public String viewCalendar() {
        return "posts/calendar";
    }

    @GetMapping("/posts.json")
    public @ResponseBody List<Post> viewAllPostsWithAjax() {
        return postsDao.findAll();
    }

//    Trail 1
    @GetMapping("/posts/{id}/edit")
    public String showEditForm(Model model, @PathVariable long id) {
        Post postToEdit = postsDao.getOne(id);
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    //  Add additional security. if they are not equal, send it to other
        if(postToEdit.getUser().getId() != currentUser.getId()) {
            return "redirect:/posts";
        }
        model.addAttribute("post", postToEdit);
        model.addAttribute("currentUser", currentUser);
        return "posts/edit-post";
    }

    //Update Post Trial 1
    @PostMapping("/posts/{id}/edit")
    public String update(
            @ModelAttribute Post postEdited,
            @PathVariable long id
    ) {
        Post postToBeUpdated = postsDao.getOne(id);
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //  Add additional security. if they are not equal, send it to other
        if(postToBeUpdated.getUser().getId() != currentUser.getId()) {
            return "redirect:/posts";
        }
        postToBeUpdated.setTitle(postEdited.getTitle());
        postToBeUpdated.setBody(postEdited.getBody());
        postsDao.save(postToBeUpdated);
        return "redirect:/posts/";
    }

    // To delete posts
    @PostMapping("/posts/{id}/delete")
    public String destroy(@PathVariable long id) {
        postsDao.deleteById(id);
        return "redirect:/posts";
    }


//    USING THE FOLLOWING TO BUILD COMMUNITY PAGE
    @GetMapping("/posts")
    public String viewPosts(Model model) {

        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }


}
