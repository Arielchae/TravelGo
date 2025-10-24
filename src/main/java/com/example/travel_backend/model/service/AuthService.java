package com.example.travel_backend.model.service;

import com.example.travel_backend.controller.dto.LoginRequest;
import com.example.travel_backend.model.vo.Auth;

public interface AuthService {
//  Auth login(String email, String password);
    Auth login(LoginRequest request);  // DTO 사용
}
