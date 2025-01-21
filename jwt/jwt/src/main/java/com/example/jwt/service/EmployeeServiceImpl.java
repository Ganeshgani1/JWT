package com.example.jwt.service;

import com.example.jwt.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity addEmployee(Employee employee) {

        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Employee> entity=new HttpEntity<>(employee,headers);

        ResponseEntity<Employee> response=restTemplate.exchange("http://localhost:8088/token/addEmp", HttpMethod.POST,entity,Employee.class);

        if(response != null && response.getStatusCode().value()==200)
            return ResponseEntity.ok(response.getBody());
        else
            return ResponseEntity.ok(response.getBody());

    }

    @Override
    public ResponseEntity getAllEmployees() throws JsonProcessingException {

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity= new HttpEntity<>(headers);

        ResponseEntity<String> response=restTemplate.exchange("http://localhost:8088/getEmp",HttpMethod.GET,entity,String.class);
       // Employee[] employees=restTemplate.getForObject("http://localhost:8080/getEmp",Employee[].class);


        List<Employee> list=null;
        //ResponseEntity response= new ResponseEntity<>(list,HttpStatus.OK);
        ObjectMapper objMapper=new ObjectMapper();

        if( response != null && response.getStatusCode().value()==200)
            return new ResponseEntity(

                    list=objMapper.readValue(response.getBody(), new TypeReference<List<Employee>>() {}),HttpStatus.OK);
        else
            return new ResponseEntity(list
                    =objMapper.readValue(response.getBody(), new TypeReference<List<Employee>>() {}),HttpStatus.NOT_FOUND);
    }
}
