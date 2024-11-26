package com.algonquin.webassignment2.demos.repository.mapper;


import com.algonquin.webassignment2.demos.repository.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersBizMapper {
    Users selectByUserNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);

    Users selectByNameOrEmail(@Param("loginName") String loginName, @Param("email") String email);

    void insertBatch(@Param("users") List<Users> users);

}