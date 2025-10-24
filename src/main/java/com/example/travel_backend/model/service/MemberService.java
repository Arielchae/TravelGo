package com.example.travel_backend.model.service;

import com.example.travel_backend.controller.dto.SignupRequest;

public interface MemberService {

    /**
     * 회원가입
     * @param request 회원가입 DTO
     * @return 성공 시 1, 실패 시 0
     */
    int signup(SignupRequest request);
}
