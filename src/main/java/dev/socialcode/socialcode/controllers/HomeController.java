package dev.socialcode.socialcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


    @GetMapping("/")
    @ResponseBody
    public String home(){
        return "Welcome to Social Code!";
    }


}
