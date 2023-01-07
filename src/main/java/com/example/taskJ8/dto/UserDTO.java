package com.example.taskJ8.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("password")
    public String getHashedPassword() {
        return password;
    }

    public void setHashedPassword(String password) {
        this.password = password;
    }
}
