package dev.socialcode.socialcode.controllers;

import dev.socialcode.socialcode.daos.UserRepository;
import dev.socialcode.socialcode.models.User;
import dev.socialcode.socialcode.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;


@Controller
public class UserController {
    private UserRepository usersDao;
    private PasswordEncoder passwordEncoder;
    private UserService usersService;

    public UserController(UserRepository usersDao, PasswordEncoder passwordEncoder, UserService usersService) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
        this.usersService = usersService;
    }


    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/sign-up";
    }
    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user, Errors validation, Model model){
        User existingUsername = usersDao.findByUsername(user.getUsername());

        if(existingUsername != null) {
            validation.rejectValue("username", "user.username", "You entered duplicated username, do you remember your email?");
        }

        if(!user.getPassword().equals(user.getPasswordToConfirm())) {
            validation.rejectValue("password",user.getPassword(), "Passwords are not match!");
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
        return "redirect:/login";
    }

    @GetMapping("/users/{id}")
    public String showUser(@PathVariable Long id, Model viewModel){
        User user = usersDao.getOne(id);
        viewModel.addAttribute("user", user);
        viewModel.addAttribute("sessionUser", usersService.loggedInUser());
        viewModel.addAttribute("showEditControls", usersService.canEditProfile(user));
        return "users/user";
    }

    @GetMapping("/users/profile")
    public String showProfile(Model viewModel){
        User logUser = usersService.loggedInUser();
    //not reading that user is logged in
        if(logUser == null){
            viewModel.addAttribute("msg", "You need to be logged in to be able to see this page");
            return "users/login";
        }
        return "redirect:/users/" + usersService.loggedInUser().getId();
    }

    //EDIT
    @GetMapping("/users/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model viewModel){
        User user = usersDao.getOne(id);
        viewModel.addAttribute("user", user);
        viewModel.addAttribute("showEditControls", usersService.canEditProfile(user));
        return "users/edit-profile";
    }

    @PostMapping("/users/{id}/edit")
    public String editUser(@PathVariable Long id, @Valid User editedUser, Errors validation, Model model){

        editedUser.setId(id);

        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("user", editedUser);
            model.addAttribute("showEditControls", checkEditAuth(editedUser));
            return "users/edit-profile";
        }
        //i believe this was hashing their new password... but if they submitted their new hashed
        //passwod with the below...their original password wouldn't work
        //
//        editedUser.setPassword(passwordEncoder.encode(editedUser.getPassword()));
        usersDao.save(editedUser);
//        return "redirect:/users/"+id;
        return "redirect:/users/" + usersService.loggedInUser().getId();
    }

    //user has rights to edit
    public Boolean checkEditAuth(User user){
        return usersService.isLoggedIn() && (user.getId() == usersService.loggedInUser().getId());
    }

    // To delete profile
    @PostMapping("/users/{id}/delete")
    public String destroy(@PathVariable long id) {
        usersDao.deleteById(id);
        return "redirect:/welcome";
    }

//


//    @PostMapping("/sign-up")
//    public String saveUser(@ModelAttribute User user) {
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        usersDao.save(user);
//        return "redirect:/welcome";
//        return "redirect:/login";
        //redirects go to urls, not to files
//    }

    //get single user view
//    @GetMapping("/users/{id}")
//    public String getUser(@PathVariable long id, Model model) {
//        User user = usersDao.getOne(id);
//        model.addAttribute("id", id);
//        model.addAttribute("user", user);
//        return "users/user";


        //also I changed the UserRepository instance from users
        // to usersDao for clarity

        //what other controllers do we need?

//    }



//    public String saveUser(@ModelAttribute User user, Errors validation){
//        User existingEmail = users.findByEmail(user.getEmail());
//        if(existingEmail != null) {
//            validation.rejectValue("email", "user.email", "Duplicated email " + user.getEmail());
//        }
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        users.save(user);
////        return "/posts/index";
//        return "redirect:/users/welcome";
//    }
    // From the Spring Validation Curriculum
//    @PostMapping("/sign-up")
//    public String saveUser(
//            @ModelAttribute User user,
//            @Valid User email,
//            Errors validation,
//            Model model
//            ) {
//        if (validation.hasErrors()) {
//            model.addAttribute("errors", validation);
//            model.addAttribute("email", email);
//            return "users/sign-up";
//        }
////        User existingEmail = users.findByEmail(user.getEmail());
////        if(existingEmail != null) {
////            validation.rejectValue("email", "user.email", "Duplicated email " + user.getEmail());
////        }
//
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        users.save(user);
//        return "redirect:/login";
//    }

}
