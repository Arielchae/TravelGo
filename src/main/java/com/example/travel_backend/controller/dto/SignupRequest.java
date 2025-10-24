package com.example.travel_backend.controller.dto;

public class SignupRequest {
    private String email;
    private String password;
    private String nickname;
    private String socialType;

    public SignupRequest() {}

    public SignupRequest(String email, String password, String nickname, String socialType) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.socialType = socialType;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getSocialType() { return socialType; }
    public void setSocialType(String socialType) { this.socialType = socialType; }
}
