package dev.socialcode.socialcode.controllers;


import dev.socialcode.socialcode.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import dev.socialcode.socialcode.daos.UserRepository;
import dev.socialcode.socialcode.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import dev.socialcode.socialcode.services.UserService;


@Controller
public class WelcomeController {
    private UserService usersService;

    public WelcomeController(UserService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/welcome")
    public String showSignupForm(Model model){
        User logUser = usersService.loggedInUser();
        if (logUser == null) {
            return "users/login";
        }
        model.addAttribute("user", new User());
        return "users/welcome";
    }

    @PostMapping("/welcome")
    public String saveUser(@ModelAttribute User user){

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        User existingEmail = users.findByEmail(user.getEmail());
//        if(existingEmail != null) {
//            validation.rejectValue("email", "user.email", "Duplicated email " + user.getEmail());
//        }
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        users.save(user);
////        return "/posts/index";
//        return "redirect:users/welcome";
        return "redirect:/login";
    }

    @GetMapping("fragments/navbar")
    public String viewNav(){
        return "fragments/navbar";
    }

}
