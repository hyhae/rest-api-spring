package com.example.taskJ8.controllers;

import com.example.taskJ8.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerIntegrationTest {

    @Autowired
    private UserController userController;

    @Test
    public final void saveUser() {
        String name = "Name1";
        String password = "Password1";
        String hashedPassword = "b9efd0093bc77cd96e6f86db09321ffe5cb4ffa7634df89df586379fe6276cc8";

        UserDTO dto = userController.save(name, password);

        assertNotNull(dto);
        assertNotNull(dto.getName());
        assertNotNull(dto.getHashedPassword());
        assertEquals(dto.getHashedPassword(), hashedPassword);
    }

}
