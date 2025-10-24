package com.example.travel_backend.controller;

import com.example.travel_backend.controller.dto.LoginRequest;
import com.example.travel_backend.controller.dto.SignupRequest;
import com.example.travel_backend.model.service.AuthService;
import com.example.travel_backend.model.vo.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /*
    // 로그인
    @PostMapping("/login")
    public Auth login(@RequestParam String email, @RequestParam String password) {
        Auth auth = authService.login(email, password);
        if(auth != null) return auth; // 로그인 성공 시 사용자 정보 반환
        return null; // 실패 시 null 반환 (프론트에서 처리)
    }*/

    // 로그인
    @PostMapping("/login")
    public Auth login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

}
