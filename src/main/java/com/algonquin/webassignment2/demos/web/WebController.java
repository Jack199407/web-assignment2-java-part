package com.algonquin.webassignment2.demos.web;

import com.algonquin.webassignment2.demos.repository.mapper.UsersBizMapper;
import com.algonquin.webassignment2.demos.repository.model.Users;
import com.algonquin.webassignment2.demos.request.LoginRequest;
import com.algonquin.webassignment2.demos.response.UserInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Objects;


@RestController
@RequestMapping("/web/assignment2")
public class WebController {

    @Resource
    private UsersBizMapper usersBizMapper;
    @CrossOrigin(origins = "http://127.0.0.1:8081")
    @PostMapping("/login")
    public RestResponse<UserInfoVO> getUserByName(@RequestBody LoginRequest request) {
        String loginName = request.getLoginName();
        String password = request.getPassword();
        Users exist = usersBizMapper.selectByUserNameAndPassword(loginName, password);
        if (Objects.isNull(exist)) {
            return RestResponse.fail(null, "User doesn't exist or incorrect password");
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(exist, userInfoVO);
        return RestResponse.success(userInfoVO, "User login successfully!");
//        if (exist != null) {
//            return RestResponse.fail(null, "login name or email duplicate");
//        }
//        Users users = new Users();
//        users.setLoginName(loginName);
//        users.setEmail(email);
//        users.setPasswd(request.getPassword());
//        users.setFirstName(request.getFirstName());
//        users.setLastName(request.getLastName());
//        usersBizMapper.insertBatch(Collections.singletonList(users));
//        UserInfoVO userInfoVO = new UserInfoVO();
//        BeanUtils.copyProperties(users, userInfoVO);
//        return RestResponse.success(userInfoVO, "User create successfully!");
    }

}
