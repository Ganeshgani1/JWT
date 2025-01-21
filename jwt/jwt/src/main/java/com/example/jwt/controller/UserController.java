package com.example.jwt.controller;

import com.example.jwt.entity.Employee;
import com.example.jwt.entity.Users;
import com.example.jwt.service.EmployeeService;
import com.example.jwt.service.UsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UsersService userService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public Users register(@RequestBody Users request){
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
       // System.out.println("inside login controller..!!");
        return userService.login(user);

    }

    @GetMapping("/getAllUsers")
    public List<Users> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/csrf")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/addEmployee")
    public ResponseEntity addEmployee(@RequestBody Employee employee){
      return employeeService.addEmployee(employee);
    }

    @GetMapping("/getAll/employees")
    public ResponseEntity getAllEmployees() throws JsonProcessingException {
        return employeeService.getAllEmployees();
    }
}
