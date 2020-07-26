package dev.socialcode.socialcode;
import dev.socialcode.socialcode.daos.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SocialcodeApplication.class)
@AutoConfigureMockMvc
public class UsersIntegrationTest {

    String TOKEN_ATTR_NAME = "org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository.CSRF_TOKEN";
    HttpSessionCsrfTokenRepository httpSessionCsrfTokenRepository = new HttpSessionCsrfTokenRepository();
    CsrfToken csrfToken = httpSessionCsrfTokenRepository.generateToken(new MockHttpServletRequest());

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserRepository usersRepository;

    // Sanity Test, just to make sure the mvc bean is working
    @Test
    public void contextLoads() throws Exception {
        assertThat(mvc).isNotNull();
    }

    @Test
    public void testShowLoginPage() throws Exception {
        this.mvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Please Log In")));
    }

    @Test
    public void testShowRegisterPage() throws Exception {
        this.mvc.perform(get("/sign-up"))
                .andExpect(status().isOk());
    }

    @Test
    public void testRedirectToLoginIfNoSessionIsActive() throws Exception {
        mvc.perform(get("/welcome"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Please Log In")));
    }

    @Test
    public void testRegisterAUser() throws Exception {

        // Create a test user
        this.mvc.perform(post("/sign-up")
                .sessionAttr(TOKEN_ATTR_NAME, csrfToken)
                .param(csrfToken.getParameterName(), csrfToken.getToken())
                .param("username", "userintegrationtest@gmail.com")
                .param("password", "pass")
                .param("passwordToConfirm", "pass")
                .param("city", "Arlington")
                .param("firstName", "Ron")
                .param("lastName", "Pal"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));

        // Delete the test user
        usersRepository.delete(usersRepository.findByUsername("userintegrationtest@gmail.com"));

        // Make sure the test user is gone from the DB
        assertThat(usersRepository.findByUsername("userintegrationtest@gmail.com") == null);
    }

}
