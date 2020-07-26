//package dev.socialcode.socialcode;
//
//import dev.socialcode.socialcode.daos.CategoriesRepository;
//import dev.socialcode.socialcode.daos.PostRepository;
//import dev.socialcode.socialcode.daos.UserRepository;
//import dev.socialcode.socialcode.models.Category;
//import dev.socialcode.socialcode.models.Post;
//import dev.socialcode.socialcode.models.User;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.mock.web.MockHttpSession;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import javax.servlet.http.HttpSession;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.junit.Assert.assertNotNull;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SocialcodeApplication.class)
//@AutoConfigureMockMvc
//public class PostsIntegrationTest {
//
//    private User testUser;
//    private Post testPost;
//    private HttpSession httpSession;
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    UserRepository userDao;
//
//    @Autowired
//    PostRepository postsDao;
//
//    @Autowired
//    CategoriesRepository categoriesDao;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Before
//    public void setup() throws Exception {
//
//        testUser = userDao.findByUsername("testUser");
//
//        // Creates the test user if not exists
//        if(testUser == null){
//            User newUser = new User();
//            newUser.setUsername("testUser");
//            newUser.setPassword(passwordEncoder.encode("pass"));
//            newUser.setPasswordToConfirm(passwordEncoder.encode("pass"));
//            newUser.setFirstName("test");
//            newUser.setFirstName("test");
//            newUser.setLastName("test");
//            newUser.setBio("test");
//            testUser = userDao.save(newUser);
//        }
//
//
//        // Throws a Post request to /login and expect a redirection to the Posts welcome page after being logged in
//        httpSession = this.mvc.perform(post("/login").with(csrf())
//                .param("username", "testUser")
//                .param("password", "pass"))
//                .andExpect(status().is(HttpStatus.FOUND.value()))
//                .andExpect(redirectedUrl("/welcome"))
//                .andReturn()
//                .getRequest()
//                .getSession();
//    }
//
//    @Test
//    public void contextLoads() {
//        // Sanity Test, just to make sure the MVC bean is working
//        assertNotNull(mvc);
//    }
//
//    @Test
//    public void testIfUserSessionIsActive() throws Exception {
//        // It makes sure the returned session is not null
//        assertNotNull(httpSession);
//    }
//
//    @Test
//    public void testPostsIndex() throws Exception {
//        Post existingPost = postsDao.findAll().get(0);
//
//        // Makes a Get request to /ads and verifies that we get some of the static text of the ads/index.html template and at least the title from the first Ad is present in the template.
//        this.mvc.perform(get("/posts"))
//                .andExpect(status().isOk())
//                // Test the static content of the page
//                .andExpect(content().string(containsString("Calendar Post")))
//                // Test the dynamic content of the page
//                .andExpect(content().string(containsString(existingPost.getTitle())));
//    }
//
//    @Test
//    public void testCreatePost() throws Exception {
//        // Makes a Post request to /ads/create and expect a redirection to the Post
//        this.mvc.perform(
//                post("/posts/create").with(csrf())
//                        .session((MockHttpSession) httpSession)
//                        // Add all the required parameters to your request like this
//                        .param("title", "test")
//                        .param("body", "for sale")
//                        .param("end_date_time", "00000000")
//                        .param("end_time", "00000000")
//                        .param("start_date_time", "00000000")
//                        .param("category", "1")
//                        .param("start_time", "00000000"))
//                .andExpect(status().is3xxRedirection());
//    }
//
//    @Test
//    public void testEditPost() throws Exception {
//        // Gets the first Ad for tests purposes
//        Post existingPost = postsDao.findAll().get(3);
//        System.out.println("ExistingPost " + existingPost.getTitle() + " id " + existingPost.getId());
//
//        // Makes a Post request to /ads/{id}/edit and expect a redirection to the Ad show page
//        this.mvc.perform(
//                post("/posts/" + existingPost.getId() + "/edit").with(csrf())
//                        .session((MockHttpSession) httpSession)
//                        .param("title", "editedTitle")
//                        .param("body", "editedBody")
//                        .param("end_date_time", "00000000")
//                        .param("end_time", "00000000")
//                        .param("start_date_time", "00000000")
//                        .param("category", "1")
//                        .param("start_time", "00000000"))
//                .andExpect(status().is3xxRedirection());
//
////         Makes a GET request to /ads/{id} and expect a redirection to the Ad show page
//        this.mvc.perform(get("/posts"))
//                .andExpect(status().isOk())
//                // Test the dynamic content of the page
//                .andExpect(content().string(containsString("Calendar Post")))
//                // Test the dynamic content of the page
//                .andExpect(content().string(containsString(existingPost.getTitle())));
//    }
//
//    @Test
//    public void testDeletePost() throws Exception {
//        // Creates a test Ad to be deleted
//        this.mvc.perform(
//                post("/posts/create").with(csrf())
//                        .session((MockHttpSession) httpSession)
//                        .param("title", "post to be deleted")
//                        .param("body", "won't last long")
//                        .param("postId", "1")
//                        .param("end_date_time", "00000000")
//                        .param("end_time", "00000000")
//                        .param("start_date_time", "00000000")
//                        .param("category", "1")
//                        .param("start_time", "00000000"))
//                .andExpect(status().is3xxRedirection());
//
//        // Get the recent Ad that matches the title
//        Post existingPost = postsDao.findByTitle("post to be deleted");
//
//        // Makes a Post request to /ads/{id}/delete and expect a redirection to the Ads index
//        this.mvc.perform(
//                post("/posts/" + existingPost.getId() + "/delete").with(csrf())
//                        .session((MockHttpSession) httpSession)
//                        .param("id", String.valueOf(existingPost.getId())))
//                .andExpect(status().is3xxRedirection());
//    }
//
//}