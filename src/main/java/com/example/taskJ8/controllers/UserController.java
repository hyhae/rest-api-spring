package com.example.taskJ8.controllers;

import com.example.taskJ8.dto.UserDTO;
import com.example.taskJ8.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userServiceImpl;

    @Autowired
    public UserController(UserService userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDTO save(@RequestParam String name , @RequestParam String password){
        return userServiceImpl.save(name, password);
    }

}
