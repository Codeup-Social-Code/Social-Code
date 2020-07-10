package dev.socialcode.socialcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class AuthenticationController {

@GetMapping("/login")
    public String showLoginFOrm(){
    return "users/login";
}


}
