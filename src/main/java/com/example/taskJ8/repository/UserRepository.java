package com.example.taskJ8.repository;


import com.example.taskJ8.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
