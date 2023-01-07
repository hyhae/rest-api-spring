package com.example.taskJ8.mappers;

import com.example.taskJ8.dto.UserDTO;
import com.example.taskJ8.entities.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "password", target = "hashedPassword")
    UserDTO userToUserDTO(User user);

    @InheritInverseConfiguration
    User userDtoToUser(UserDTO userDTO);
}
