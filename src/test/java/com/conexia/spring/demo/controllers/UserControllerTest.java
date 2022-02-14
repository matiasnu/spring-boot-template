package com.conexia.spring.demo.controllers;

import com.conexia.spring.demo.models.User;
import com.conexia.spring.demo.services.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetUsers() throws Exception {
        User user = new User();
        user.setFirstName("Matias");
        user.setLastName("Nuñez");
        user.setEmail("mnunez@conexia.com");
        List<User> users = Arrays.asList(user);

        Mockito.when(userService.getUsers()).thenReturn(users);

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", Matchers.is("Matias")))
                .andExpect(jsonPath("$[0].lastName", Matchers.is("Nuñez")))
                .andExpect(jsonPath("$[0].email", Matchers.is("mnunez@conexia.com")));
    }
}
