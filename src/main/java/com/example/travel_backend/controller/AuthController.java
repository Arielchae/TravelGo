package com.example.travel_backend.controller;


import com.example.travel_backend.model.vo.Auth;
import com.example.travel_backend.model.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    //로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Auth auth, HttpSession session) {
        Auth loginUser = authService.login(auth.getEmail(), auth.getPassword());
        if(loginUser != null) {
            session.setAttribute("loginUser", loginUser);
            return ResponseEntity.ok(loginUser);
        } else {
            return ResponseEntity.status(401).body("아이디 또는 비밀번호가 일치하지 않습니다.");
        }
    }

    //로그인 사용자 정보 확인 (POST)
    @PostMapping("/me")
    public ResponseEntity<?> getLoginUser(HttpSession session) {
        Auth loginUser = (Auth) session.getAttribute("loginUser");
        if (loginUser != null) {
            return ResponseEntity.ok(loginUser);
        } else {
            return ResponseEntity.status(401).body("로그인 정보가 없습니다.");
        }
    }

    //로그아웃 (POST)
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("로그아웃 되었습니다.");
    }
}
