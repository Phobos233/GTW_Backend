package com.phobos.goldentrianglewebsitebackend.Model.dto;

import lombok.Data;

@Data
public class LoginInfo {
    private String username;
    private long id;
    private String token;

    public LoginInfo(String username, long id, String token) {
        this.username = username;
        this.id = id;
        this.token = token;
    }
}
