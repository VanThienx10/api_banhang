package com.example.api_banhang.payload;

import lombok.Data;

@Data
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Thien";

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
