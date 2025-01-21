package com.example.jwt.service;

import com.example.jwt.entity.CustomUserDeatils;
import com.example.jwt.entity.Users;
import com.example.jwt.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user=userRepo.findByName(username);

        if(!user.isPresent()){
         throw new UsernameNotFoundException("No user found with name: "+username);
        }
        return new CustomUserDeatils(user.get());
    }
}
