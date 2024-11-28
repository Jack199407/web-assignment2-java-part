package com.algonquin.webassignment2.demos.response;

import lombok.Data;

@Data
public class UserInfoVO {
    private Integer userId;

    private String loginName;

    private String passwd;

    private String email;

    private String firstName;

    private String lastName;
}
