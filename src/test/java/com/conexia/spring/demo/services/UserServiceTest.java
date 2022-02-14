package com.conexia.spring.demo.services;

import com.conexia.spring.demo.models.User;
import com.conexia.spring.demo.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Test
    public void testFindAll() {
        List<User> users = new ArrayList<>();
        User userOne = new User();
        User userTwo = new User();

        users.add(userOne);
        users.add(userTwo);

        when(userRepository.findAll()).thenReturn(users);

        List<User> userList = userService.getUsers();

        assertEquals(2, userList.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testCreateOrSaveEmployee()
    {
        User user = new User();
        user.setFirstName("Matias");
        user.setLastName("Nuñez");
        user.setEmail("mnunez@conexia.com");

        userService.createUser(user);

        verify(userRepository, times(1)).save(user);
    }
}
