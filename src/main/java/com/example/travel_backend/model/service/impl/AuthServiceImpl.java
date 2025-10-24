package com.example.travel_backend.model.service.impl;

import com.example.travel_backend.controller.dto.LoginRequest;
import com.example.travel_backend.model.service.AuthService;
import com.example.travel_backend.mapper.AuthMapper;
import com.example.travel_backend.model.vo.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
    private final AuthMapper authMapper;

    @Autowired
    public AuthServiceImpl(AuthMapper authMapper) {
        this.authMapper = authMapper;
    }

    /*@Override
    public Auth login(String email, String password) {
        Auth auth = authMapper.selectByEmail(email);
        if(auth != null && auth.getPassword().equals(password)) {
            return auth;
        }
        return null;
    }*/

    @Override
    public Auth login(LoginRequest request) {
        Auth auth = authMapper.selectByEmail(request.getEmail());
        if(auth != null && auth.getPassword().equals(request.getPassword())) {
            return auth;
        }
        return null;
    }

}
