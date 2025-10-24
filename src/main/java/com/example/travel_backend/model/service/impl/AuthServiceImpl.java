package com.example.travel_backend.model.service.impl;

import com.example.travel_backend.mapper.AuthMapper;
import com.example.travel_backend.model.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthMapper authMapper;

    @Override
    public Auth login(String email, String password) {
        Auth user = authMapper.selectByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
