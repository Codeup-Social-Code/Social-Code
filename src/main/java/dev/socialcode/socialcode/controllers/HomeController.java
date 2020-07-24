package dev.socialcode.socialcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String homepage(){
        return "posts/home";
    }


    @GetMapping("/about")
    public String aboutUs() {
        return "posts/aboutus";
    }




}
