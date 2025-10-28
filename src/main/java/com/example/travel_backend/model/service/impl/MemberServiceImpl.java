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
        member.setName(request.getName());  // 필수! SignupRequest에서 받은 name 값을 Member VO에 반드시 설정해야 합니다. (null 허용 안하면 꼭 적어줌.)
        // 2. null 허용 컬럼 처리 (옵션)
        //    DB가 null을 허용하므로, 별도로 값을 설정하지 않으면 Java 기본값인 null이 유지됩니다.
        //    만약 'LOCAL' 가입 시 role의 기본값을 'USER'로 설정하고 싶다면 다음과 같이 작성합니다.
        // member.setRole("USER");
        member.setUsername(request.getName()); // 예시: 이름을 username으로 사용
        member.setRole("USER"); // 예시: 기본 권한 설정
        member.setSocialId(null); // 로컬 회원가입이므로 null (DB에서 null 허용 시)

        int result = memberMapper.insertMember(member);
        if(result > 0) {
            logger.info("회원가입 성공: {}", request.getEmail());
        }
        return result;
    }
}
