package com.example.travel_backend.mapper;

import com.example.travel_backend.model.vo.Auth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthMapper {
    /**
     * 로그인용: 이메일로 사용자 정보 조회
     */
    Auth selectByEmail(@Param("email") String email);

}
