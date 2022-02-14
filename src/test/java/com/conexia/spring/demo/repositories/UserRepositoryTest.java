package com.conexia.spring.demo.repositories;

import com.conexia.spring.demo.models.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("prod")
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testCreateReadDelete() {
        User user = new User();
        user.setFirstName("Matias");
        user.setLastName("Nuñez");
        user.setEmail("mnunez@conexia.com");
        userRepository.save(user);

        Iterable<User> users = userRepository.findAll();
        Assertions.assertThat(users).extracting(User::getFirstName).containsOnly("Matias");
        Assertions.assertThat(users).extracting(User::getLastName).containsOnly("Nuñez");
        Assertions.assertThat(users).extracting(User::getEmail).containsOnly("mnunez@conexia.com");

        userRepository.deleteAll();
        Assertions.assertThat(userRepository.findAll().isEmpty());
    }
}
