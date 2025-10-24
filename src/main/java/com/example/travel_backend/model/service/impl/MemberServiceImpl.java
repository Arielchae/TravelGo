package com.example.travel_backend.model.service.impl;

import com.example.travel_backend.controller.dto.SignupRequest;
import com.example.travel_backend.model.service.MemberService;
import com.example.travel_backend.mapper.MemberMapper;
import com.example.travel_backend.model.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
    private final MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public int signup(SignupRequest request) {
        logger.info("회원가입 시작, email={}", request.getEmail());

        // 중복 이메일 체크
        int existCount = memberMapper.countByEmail(request.getEmail());
        if(existCount > 0) {
            logger.warn("회원가입 실패 - 중복 이메일: {}", request.getEmail());
            return 0;
        }

        // DTO → VO 변환
        Member member = new Member();
        member.setEmail(request.getEmail());
        member.setPassword(request.getPassword());
        member.setNickname(request.getNickname());
        member.setSocialType(request.getSocialType());

        int result = memberMapper.insertMember(member);
        if(result > 0) {
            logger.info("회원가입 성공: {}", request.getEmail());
        }
        return result;
    }
}
