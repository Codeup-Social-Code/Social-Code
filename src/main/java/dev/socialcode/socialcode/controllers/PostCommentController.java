package dev.socialcode.socialcode.controllers;

import dev.socialcode.socialcode.daos.CommentsRepository;
import dev.socialcode.socialcode.daos.PostRepository;
import dev.socialcode.socialcode.daos.UserRepository;
import dev.socialcode.socialcode.models.Comment;
import dev.socialcode.socialcode.models.Post;
import dev.socialcode.socialcode.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class PostCommentController {

    private PostRepository postsDao;
    private UserRepository usersDao;
    private CommentsRepository commentsDao;

    public PostCommentController(PostRepository postRepository, UserRepository userRepository, CommentsRepository commentsRepository) {
        this.postsDao = postRepository;
        this.usersDao = userRepository;
        this.commentsDao = commentsRepository;
    }

    @PostMapping("/comments/create")
    public String createComment(@ModelAttribute Comment commentToBeSaved, @RequestParam(name = "postId") String postId, Principal principal) {
        Post post = postsDao.getOne(Long.parseLong(postId));
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commentToBeSaved.setPost(post);
        commentToBeSaved.setUser(currentUser);
        Date currentDate = new Date();
        commentToBeSaved.setCreateDate(currentDate);
        Comment savedComment = commentsDao.save(commentToBeSaved);
        return "redirect:/posts/" + savedComment.getPost().getId();
    }


//    @GetMapping("/comments/create")
//    public String showCommentForm(Model viewModel) {
//        viewModel.addAttribute("comment", new Comment());
//        return "posts/comments";
//    }
//
//    @GetMapping("/comments")
//    public String showAll(Model model) {
//        List<Comment> comments = commentsDao.findAll();
//        model.addAttribute("comments", comments);
//        return "posts/viewComments";
//    }

}
