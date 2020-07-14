package dev.socialcode.socialcode.controllers;

import dev.socialcode.socialcode.daos.CommentsRepository;
import dev.socialcode.socialcode.daos.PostRepository;
import dev.socialcode.socialcode.daos.RSVPsRepository;
import dev.socialcode.socialcode.models.Comment;
import dev.socialcode.socialcode.models.Post;
import dev.socialcode.socialcode.models.RSVP;
import dev.socialcode.socialcode.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class RSVPController {

    private PostRepository postsDao;
    private RSVPsRepository rsvpsDao;

    public RSVPController(PostRepository postsDao, RSVPsRepository rsvpsDao) {
        this.postsDao = postsDao;
        this.rsvpsDao = rsvpsDao;
    }

    @PostMapping("/comments/create")
    public String saveRSVP(@ModelAttribute RSVP RSVPtoBeSaved, @RequestParam(name = "postId") String postId) {
        Post post = postsDao.getOne(Long.parseLong(postId));
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RSVPtoBeSaved.setPost(post);
        RSVPtoBeSaved.setUser(currentUser);
        RSVP savedRSVP = rsvpsDao.save(RSVPtoBeSaved);
        return "redirect:/posts/" + savedRSVP.getPost().getId();
    }

}
