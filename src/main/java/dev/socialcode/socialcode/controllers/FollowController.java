//package dev.socialcode.socialcode.controllers;
//
//import dev.socialcode.socialcode.daos.*;
//import dev.socialcode.socialcode.models.*;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.Date;
//import java.util.List;
//
//@Controller
//public class FollowController {
//
//    private UserRepository usersDao;
//    private FollowerRepository followersDao;
//    public FollowController(UserRepository usersDao, FollowerRepository followersDao) {
//        this.usersDao = usersDao;
//        this.followersDao = followersDao;
//    }
//
//    @GetMapping("users/follow-test")
//    public String

//
//    @PostMapping("/users/follow-test")
//    public String saveRSVP(@ModelAttribute Follower followertoBeSaved,  @RequestParam(name = "followId") String followId ) {
//        Follower follower = followersDao.getOne(Long.parseLong(followId));
//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        followertoBeSaved.setUser(currentUser);
//        Follower savedFollower = followersDao.save(followertoBeSaved);
//        return "users/follow-test" + savedFollower.getUser().getId();
//    }
//
//}
