package dev.socialcode.socialcode;


import dev.socialcode.socialcode.daos.PostRepository;
import dev.socialcode.socialcode.daos.UserRepository;
import dev.socialcode.socialcode.models.Post;
import dev.socialcode.socialcode.models.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SocialcodeApplication.class)
@AutoConfigureMockMvc
public class SocialCodeIntegrationTests {

    String TOKEN_ATTR_NAME = "org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository.CSRF_TOKEN";
    HttpSessionCsrfTokenRepository httpSessionCsrfTokenRepository = new HttpSessionCsrfTokenRepository();
    CsrfToken csrfToken = httpSessionCsrfTokenRepository.generateToken(new MockHttpServletRequest());

    private User testUser;
    private HttpSession httpSession;
    private UserRepository usersRepository;

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserRepository userDao;

    @Autowired
    PostRepository postsDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void setup() throws Exception {

        testUser = userDao.findByUsername("testUser@codeup.com");

        // Creates the test user if not exists
        if(testUser == null){
            User newUser = new User();
            newUser.setUsername("testUser@codeup.com");
            newUser.setFirstName("testUser");
            newUser.setLastName("testUser");
            newUser.setPassword(passwordEncoder.encode("pass"));
            newUser.setPasswordToConfirm(passwordEncoder.encode("pass"));
            testUser = userDao.save(newUser);
        }

        // Throws a Post request to /login and expect a redirection to the Posts index page after being logged in
        httpSession = this.mvc.perform(post("/login").with(csrf())
                .param("username", "testUser@codeup.com")
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
    public void testShowCreatePostPage() throws Exception {
        this.mvc.perform(get("/posts/create"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/login"));
    }

    @Test
    public void testCreateAPost() throws Exception {

        User testUser = userDao.findByUsername("testUser@codeup.com");
        assertThat(testUser != null);

        this.mvc.perform(post("/posts/create")
                .sessionAttr(TOKEN_ATTR_NAME, csrfToken)
                .param(csrfToken.getParameterName(), csrfToken.getToken())
                .param("title", "test post")
                .param("body", "lorem")
                .param("categories", "CSS")
                .param("user", String.valueOf(testUser.getId()))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/"));

    }

    @Test
    public void testPostsIndex() throws Exception {
        Post existingPost = postsDao.findAll().get(0);

        // Makes a Get request to /ads and verifies that we get some of the static text of the ads/index.html template and at least the title from the first Ad is present in the template.
        this.mvc.perform(get("/posts"))
                .andExpect(status().isOk())
                // Test the static content of the page
                .andExpect(content().string(containsString("lorem")))
                // Test the dynamic content of the page
                .andExpect(content().string(containsString(existingPost.getTitle())));
    }

    @Test
    public void testShowRegisterPage() throws Exception {
        this.mvc.perform(get("/sign-up"))
                .andExpect(status().isOk());
    }

    @Test
    public void testRedirectToLoginIfNoSessionIsActive() throws Exception {
        mvc.perform(get("/users/profile"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Please Log In")));
    }

    @Test
    public void testRegisterAUser() throws Exception {

        // Create a test user
        this.mvc.perform(post("/login")
                .sessionAttr(TOKEN_ATTR_NAME, csrfToken)
                .param(csrfToken.getParameterName(), csrfToken.getToken())
                .param("firstName", "stacy")
                .param("lastName", "parker")
                .param("username", "testUser@codeup.com")
                .param("password", "pass")
                .param("passwordToConfirm", "pass")
                .param("city", "dallas")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/welcome"));
    }






//Still needs work
//    @Test
//    public void testShowPost() throws Exception {
//        Post existingPost = postsDao.findAll().get(0);
//
//        // Makes a Get request to /posts/{id} and expect a redirection to the Post show page
//        this.mvc.perform(get("/posts/" + existingPost.getId()))
////                + existingPost.getId()
//                .andExpect(status().isOk())
////                 Test the dynamic content of the page
//                .andExpect(content().string(containsString(existingPost.getBody())));
//    }

}
