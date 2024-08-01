/*
package org.ac.cst8277.liang.ping.service;

import org.ac.cst8277.liang.ping.entity.User;
import org.ac.cst8277.liang.ping.entity.Token;
import org.ac.cst8277.liang.ping.repository.UserRepository;
import org.ac.cst8277.liang.ping.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Token authenticate(String userName) {
        User user = userRepository.findByUserName(userName);
        if (user != null) {
            Token token = new Token();
            token.setUser(user);
            token.setToken(UUID.randomUUID().toString());
            return tokenRepository.save(token);
        }
        return null;
    }

    public boolean validateToken(String token) {
        return tokenRepository.findById(token).isPresent();
    }


}*/
