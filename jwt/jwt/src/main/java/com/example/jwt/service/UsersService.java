package com.example.jwt.service;

import com.example.jwt.entity.Employee;
import com.example.jwt.entity.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsersService {
    Users registerUser(Users request);

    List<Users> getUsers();

    String login(Users user);


}
