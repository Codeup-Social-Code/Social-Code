package dev.socialcode.socialcode;


import dev.socialcode.socialcode.daos.CommentsRepository;
import dev.socialcode.socialcode.daos.PostRepository;
import dev.socialcode.socialcode.daos.RSVPsRepository;
import dev.socialcode.socialcode.daos.UserRepository;
import dev.socialcode.socialcode.models.Comment;
import dev.socialcode.socialcode.models.Post;
import dev.socialcode.socialcode.models.RSVP;
import dev.socialcode.socialcode.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SocialcodeApplication.class)
@AutoConfigureMockMvc
public class RSVPsIntegrationTest {

    private User testUser;
    private HttpSession httpSession;
    private Comment commentToView;
    private RSVP rsvpToView;
    private Post testPost;

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserRepository userDao;

    @Autowired
    PostRepository adsDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    CommentsRepository commentsDao;

    @Autowired
    PostRepository postsDao;

    @Autowired
    RSVPsRepository rsvpsDao;

    @Before
    public void setup() throws Exception {

        testUser = userDao.findByUsername("testUser");


        // Creates the test user if not exists
        if(testUser == null){
            User newUser = new User();
            newUser.setUsername("testUser@codeup.com");
            newUser.setPassword(passwordEncoder.encode("pass"));
            testUser = userDao.save(newUser);
        }

//        if(commentToView == null) {
//            Comment commentToView = new Comment();
//            commentToView.setBody("This is a comment to view");
//            commentToView.setPost(postsDao.getOne(1L));
//            commentToView.setUser(testUser);
//            commentsDao.save(commentToView);
//            commentToView = commentsDao.findByBody("This is a comment to view");
//        }

        // Throws a Post request to /login and expect a redirection to the Ads index page after being logged in
        httpSession = this.mvc.perform(post("/login").with(csrf())
                .param("username", "testUser")
                .param("password", "pass"))
                .andExpect(status().is(HttpStatus.FOUND.value()))
                .andExpect(redirectedUrl("/welcome"))
                .andReturn()
                .getRequest()
                .getSession();
    }

    @Test
    public void contextLoads() {
        // Sanity Test, just to make sure the MVC bean is working
        assertNotNull(mvc);
    }

    @Test
    public void testIfUserSessionIsActive() throws Exception {
        // It makes sure the returned session is not null
        assertNotNull(httpSession);
    }

    @Test
    public void RSVP() throws Exception {

        this.mvc.perform(
                post("/comments/create").with(csrf())
                        .session((MockHttpSession) httpSession)
                        // Add all the required parameters to your request like this
                        .param("body", "Test Comment!")
                        .param("postId", "1"))
                .andExpect(status().is3xxRedirection());

    }


}
