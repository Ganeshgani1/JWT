package com.example.jwt.service;

import com.example.jwt.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity addEmployee(Employee employee);

    ResponseEntity getAllEmployees() throws JsonProcessingException;
}
