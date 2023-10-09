package com.example.api_banhang.payload;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
