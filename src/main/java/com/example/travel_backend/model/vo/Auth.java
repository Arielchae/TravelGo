package com.example.travel_backend.model.vo;

public class Auth {
    private Long userId;        // USER_ID
    private String email;       // EMAIL
    private String password;    // PASSWORD
    private String nickname;    // NICKNAME
    private String socialType;  // SOCIAL_TYPE

    // 기본 생성자
    public Auth() {}

    // 전체 필드 생성자
    public Auth(Long userId, String email, String password, String nickname, String socialType) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.socialType = socialType;
    }

    // Getter & Setter
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getSocialType() { return socialType; }
    public void setSocialType(String socialType) { this.socialType = socialType; }

    @Override
    public String toString() {
        return "Auth{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", socialType='" + socialType + '\'' +
                '}';
    }
}
