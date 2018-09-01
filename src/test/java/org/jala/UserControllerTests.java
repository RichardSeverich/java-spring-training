package org.jala;

import org.jala.Services.UsersService;
import org.jala.controllers.UsersController;
import org.jala.support.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * Created by Richard Severich on 28/10/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)
public class UserControllerTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private UsersService usersService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * Test get all users.
     *
     * @throws Exception generic exception.
     */
    @Test
    public void getAllUsers() throws Exception {
        assertThat(this.usersService).isNotNull();
        mockMvc.perform(get(Paths.BASE_PATH_USERS)).andExpect(status().isOk());
    }
}
