package com.example.taskJ8.services;

import com.example.taskJ8.dto.UserDTO;

public interface UserService {
    UserDTO save(String name, String password);
}
