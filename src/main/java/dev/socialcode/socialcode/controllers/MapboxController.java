package dev.socialcode.socialcode.controllers;

import dev.socialcode.socialcode.daos.UserRepository;
import dev.socialcode.socialcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MapboxController {

    private UserRepository usersDao;

    public MapboxController(UserRepository usersDao) {
        this.usersDao = usersDao;
    }

    @GetMapping("/mapbox")
    public String viewMapbox(Model model) {
        return "posts/mapbox";
    }

    @GetMapping("/users.json")
    public @ResponseBody
    List<User> viewAllUserInJSONFormat() {
        return usersDao.findAll();
    }
}
