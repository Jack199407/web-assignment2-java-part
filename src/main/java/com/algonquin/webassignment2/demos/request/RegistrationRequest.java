package com.algonquin.webassignment2.demos.request;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String loginName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
