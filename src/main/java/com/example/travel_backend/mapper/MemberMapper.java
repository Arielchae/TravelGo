package com.example.travel_backend.mapper;

import com.example.travel_backend.model.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    /**
     * 회원가입용: 신규 사용자 정보 등록
     */
    int insertMember(Member member);

    /**
     * 회원가입 중복 체크용: 이메일이 존재하는지 개수만 확인
     */
    int countByEmail(@Param("email") String email);

}
