package com.example.travel_backend.model.vo;

public class Member {
    private Long userId;
    private String username;       // 추가
    private String email;
    private String password;
    private String name;           // 추가
    private String nickname;       // 기존
    private String role;           // 추가
    private String socialType; // 추가 (or socialType, 네이밍 통일)
    private String socialId;       // 추가

    // getters / setters 모두 추가

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSocialType() {
        return socialType;
    }

    public void setSocialType(String socialProvider) {
        this.socialType = socialProvider;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", role='" + role + '\'' +
                ", socialProvider='" + socialType + '\'' +
                ", socialId='" + socialId + '\'' +
                '}';
    }
}
