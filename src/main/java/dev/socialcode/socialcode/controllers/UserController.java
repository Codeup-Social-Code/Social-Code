package dev.socialcode.socialcode.controllers;

import dev.socialcode.socialcode.daos.PostRepository;
import dev.socialcode.socialcode.daos.UserRepository;
import dev.socialcode.socialcode.models.Post;
import dev.socialcode.socialcode.models.RSVP;
import dev.socialcode.socialcode.models.User;
import dev.socialcode.socialcode.models.UserWithRoles;
import dev.socialcode.socialcode.services.EmailService;
import dev.socialcode.socialcode.services.UserService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


@Controller
public class UserController {
    private UserRepository usersDao;
    private PasswordEncoder passwordEncoder;
    private PostRepository postsDao;
    private UserService usersService;
    private EmailService emailService;


    public UserController(UserRepository usersDao, PasswordEncoder passwordEncoder, UserService usersService, PostRepository postRepository, EmailService emailService) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
        this.usersService = usersService;
        this.postsDao = postRepository;
        this.emailService = emailService;
    }


    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user, Errors validation, Model model) {
        User existingUsername = usersDao.findByUsername(user.getUsername());

        if (existingUsername != null) {
            validation.rejectValue("username", "user.username", "You entered duplicated username, do you remember your email?");
        }

        if (!user.getPassword().equals(user.getPasswordToConfirm())) {
            validation.rejectValue("password", user.getPassword(), "Passwords are not match!");
        }

        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("user", user);
            return "users/sign-up";
        }

        String hash = passwordEncoder.encode(user.getPassword());
        String hashForConfirm = passwordEncoder.encode(user.getPasswordToConfirm());
        user.setPassword(hash);
        user.setPasswordToConfirm(hashForConfirm);

        usersDao.save(user);
        authenticate(user);
        User savedUser = usersDao.save(user);
        emailService.prepareAndSend(savedUser, "A new account has been created", "Thank you for signing up your One stop website where you can grow! Your username: " + savedUser.getUsername());

        return "redirect:/welcome";
    }

    private void authenticate(User user) {
        UserDetails userDetails = new UserWithRoles(user, Collections.emptyList());
        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(auth);
    }


    @GetMapping("/users/{id}")
    public String showUser(@PathVariable Long id, Model viewModel) {
        User logUser = usersService.loggedInUser();
        if (logUser == null) {
            return "users/login";
        }

        User user = usersDao.getOne(id);

        List<Post> userPosts = postsDao.findPostsByUser_Id(id);
        viewModel.addAttribute("userPosts", userPosts);
        viewModel.addAttribute("user", user);
        int numberOfFollowers = user.getFollowers().size();
        viewModel.addAttribute("sessionUser", usersService.loggedInUser());
        viewModel.addAttribute("showEditControls", usersService.canEditProfile(user));
        viewModel.addAttribute("followers", numberOfFollowers);

        return "users/user";
    }

    @PostMapping("user/{id}/follow")
    public String saveFollower(@PathVariable long id) {
        User loggedInUser = usersService.loggedInUser();
        User userToFollow = usersDao.getOne(id);
        List <User> currentFollowers =  userToFollow.getFollowers();
        currentFollowers.add(loggedInUser);
        userToFollow.setFollowers(currentFollowers);
        usersDao.save(userToFollow);
        return "redirect:/users/" + userToFollow.getId();
    }


    @GetMapping("/users/profile")
    public String showProfile(Model viewModel) {
        User logUser = usersService.loggedInUser();
        //not reading that user is logged in
        if (logUser == null) {
            viewModel.addAttribute("msg", "You need to be logged in to be able to see this page");
            return "users/login";
        }
        return "redirect:/users/" + usersService.loggedInUser().getId();
    }


    // To view all users
    @GetMapping("/users/view-all")
    public String viewAllUsers(Model m) {
        User logUser = usersService.loggedInUser();
        if (logUser == null) {
            return "users/login";
        }
        List<User> viewAll = usersDao.findAll();
        m.addAttribute("viewAll", viewAll);
        return "users/view-all";
    }

    //EDIT
    @GetMapping("/users/{id}/edit")
  public String showEditForm(@PathVariable Long id, Model viewModel){
          User logUser = usersService.loggedInUser();
        if (logUser == null) {
            return "users/login";
        }

        viewModel.addAttribute("apiKey", apiFromProperties);
        User user = usersDao.getOne(id);
        viewModel.addAttribute("user", user);
        viewModel.addAttribute("sessionUser", usersService.loggedInUser());
        //still need to create "showEditPage"
//        viewModel.addAttribute("showEditPage", usersService.isProfileOwner(user));
        viewModel.addAttribute("showEditControls", usersService.canEditProfile(user));
        return "users/edit-profile";
    }

    @PostMapping("/users/{id}/edit")
    public String editUser(@PathVariable Long id, @Valid User editedUser, Errors validation, Model model) {
        User user = usersDao.getOne(id);
        String password = user.getPassword();
        String passwordToConfirm = user.getPasswordToConfirm();
        editedUser.setId(id);
        editedUser.setPassword(password);
        editedUser.setPasswordToConfirm(passwordToConfirm);

        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("user", editedUser);
            model.addAttribute("showEditControls", checkEditAuth(editedUser));
            return "users/edit-profile";
        }
        usersDao.save(editedUser);
        return "redirect:/users/" + usersService.loggedInUser().getId();
    }

    //user has rights to edit
    public Boolean checkEditAuth(User user) {
        return usersService.isLoggedIn() && (user.getId() == usersService.loggedInUser().getId());
    }

    // To delete profile
    @PostMapping("/users/{id}/delete")
    public String destroy(@PathVariable long id) {
        usersDao.deleteById(id);
        return "redirect:/welcome";
    }
  
    //Adding filestack api
    @Value("${filestack_api_key}")
        private String apiFromProperties;

    //Search Functionality
    @GetMapping("/users/search")
    public String showSearch(Model model, @RequestParam(name = "term") String term) {
        List<User> userNameResult = usersDao.searchByNameLike(term);
        System.out.println(userNameResult.size()); // 2 or 0 depends on num
        model.addAttribute("userNameResult", userNameResult);

        return "users/view-all-search";
    }

}

