package dev.socialcode.socialcode.controllers;

import dev.socialcode.socialcode.daos.CommentsRepository;
import dev.socialcode.socialcode.daos.PostRepository;
import dev.socialcode.socialcode.daos.RSVPsRepository;
import dev.socialcode.socialcode.daos.UserRepository;
import dev.socialcode.socialcode.models.Comment;
import dev.socialcode.socialcode.models.Post;
import dev.socialcode.socialcode.models.RSVP;
import dev.socialcode.socialcode.models.User;
import dev.socialcode.socialcode.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class RSVPController {

    private PostRepository postsDao;
    private RSVPsRepository rsvpsDao;
    private UserService usersService;
    private UserRepository usersDao;

    public RSVPController(PostRepository postsDao, RSVPsRepository rsvpsDao, UserService usersService, UserRepository usersRepository) {
        this.postsDao = postsDao;
        this.rsvpsDao = rsvpsDao;
        this.usersService = usersService;
        this.usersDao = usersRepository;

    }

    @PostMapping("/posts/rsvp")
    public String saveRSVP(@ModelAttribute RSVP RSVPtoBeSaved, @RequestParam(name = "postId") String postId) {
        User loggedInUser = usersService.loggedInUser();
        List<RSVP> postToRSVP = rsvpsDao.findRSVPSByPostId(Long.parseLong(postId));
        for(RSVP rsvp: postToRSVP){
            System.out.println(rsvp.getUser().getUsername());
            if(rsvp.getUser().getId() == loggedInUser.getId()){
                return "redirect:/posts/" + rsvp.getPost().getId();
            }
        }

        Post post = postsDao.getOne(Long.parseLong(postId));
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RSVPtoBeSaved.setPost(post);
        RSVPtoBeSaved.setUser(currentUser);
        RSVP savedRSVP = rsvpsDao.save(RSVPtoBeSaved);
        return "redirect:/posts/" + savedRSVP.getPost().getId();
    }

}
