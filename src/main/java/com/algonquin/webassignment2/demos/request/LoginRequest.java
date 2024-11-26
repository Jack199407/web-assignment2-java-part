package com.algonquin.webassignment2.demos.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String loginName;
    private String password;
}
