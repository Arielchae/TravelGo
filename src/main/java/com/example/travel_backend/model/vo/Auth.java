package com.travelgo.model.vo;

public class Auth {

    private String memberId;     // 로그인할 아이디
    private String memberPw;     // 비밀번호
    private String memberName;   // 사용자 이름 (로그인 성공 후 표시용)
    private String memberType;   // 사용자 유형 (예: USER, ADMIN)

    // 기본 생성자
    public Auth() {}

    // 로그인 요청용 생성자
    public Auth(String memberId, String memberPw) {
        this.memberId = memberId;
        this.memberPw = memberPw;
    }

    // 전체 필드 생성자 (선택)
    public Auth(String memberId, String memberPw, String memberName, String memberType) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberType = memberType;
    }

    // Getter & Setter
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }
    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberType() {
        return memberType;
    }
    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    @Override
    public String toString() {
        return "Auth [memberId=" + memberId + ", memberName=" + memberName + ", memberType=" + memberType + "]";
    }
}
