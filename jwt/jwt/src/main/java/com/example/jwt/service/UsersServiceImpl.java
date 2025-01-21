package com.example.jwt.service;

import com.example.jwt.entity.Users;
import com.example.jwt.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    private final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    @Override
    public Users registerUser(Users request) {
        request.setPassWord(passwordEncoder.encode(request.getPassWord()));
        return userRepo.save(request);
    }

    @Override
    public List<Users> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public String login(Users user) {
        //Optional<Users> users=userRepo.findByName(user.getName());

        Authentication authentication=
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                user.getName(),user.getPassWord()
                        ));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(user);
        else
            return "User not Found";
    }
}
