package com.example.taskJ8.services.impl;

import com.example.taskJ8.dto.UserDTO;
import com.example.taskJ8.entities.User;
import com.example.taskJ8.mappers.UserMapper;
import com.example.taskJ8.repository.UserRepository;
import com.example.taskJ8.services.UserService;
import com.example.taskJ8.utils.PasswordHasher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional()
    public UserDTO save(String name, String password) {
        try{
            password = hashPassword(name, password);

            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user = userRepository.save(user);

            return userMapper.userToUserDTO(user);
        }
        catch(Exception e){
            logger.error("Failed to save user: {} due to {}", name, e.getMessage());
            return null;
        }
    }

    private String hashPassword(String name, String password) throws NoSuchAlgorithmException {
        password = PasswordHasher.hashPassword(name+password);
        return password;
    }
}
