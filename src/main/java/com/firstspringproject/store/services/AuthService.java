package com.firstspringproject.store.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.firstspringproject.store.entities.User;
import com.firstspringproject.store.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;

    public User getCurrentUser(){
        var authntication = SecurityContextHolder.getContext().getAuthentication();

        var userId = (Long) authntication.getPrincipal();

        return userRepository.findById(userId).orElse(null);

    }

}
