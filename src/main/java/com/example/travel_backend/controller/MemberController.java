package com.example.travel_backend.controller;

import com.example.travel_backend.controller.dto.SignupRequest;
import com.example.travel_backend.model.service.MemberService;
import com.example.travel_backend.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 회원가입
     */
    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request) {
        int result = memberService.signup(request);
        if(result > 0) {
            return "success";
        } else {
            return "fail"; // 중복 이메일 등
        }
    }
}
