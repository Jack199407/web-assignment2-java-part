package com.algonquin.webassignment2.demos.web;

import com.algonquin.webassignment2.demos.repository.mapper.TaskLogsBizMapper;
import com.algonquin.webassignment2.demos.repository.mapper.TasksBizMapper;
import com.algonquin.webassignment2.demos.repository.mapper.UsersBizMapper;
import com.algonquin.webassignment2.demos.repository.model.Tasks;
import com.algonquin.webassignment2.demos.repository.model.Users;
import com.algonquin.webassignment2.demos.request.LoginRequest;
import com.algonquin.webassignment2.demos.request.RegistrationRequest;
import com.algonquin.webassignment2.demos.request.TaskDisplayRequest;
import com.algonquin.webassignment2.demos.response.TaskInfoVO;
import com.algonquin.webassignment2.demos.response.UserInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/web/assignment2")
public class WebController {

    @Resource
    private UsersBizMapper usersBizMapper;
    @Resource
    private TasksBizMapper tasksBizMapper;
    @Resource
    private TaskLogsBizMapper taskLogsBizMapper;
    @CrossOrigin(origins = "http://127.0.0.1:5500")
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
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/task/display")
    public RestResponse<List<TaskInfoVO>> getTasks(@RequestBody TaskDisplayRequest request) {
        if (Objects.isNull(request.getUserId())) {
            return RestResponse.fail(null, "User Id can not be null");
        }
        LocalDateTime dueDate = null;
        if (Objects.nonNull(request.getDueDate())) {
            dueDate = LocalDateTime.parse(request.getDueDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
        List<Tasks> tasks = tasksBizMapper.listByUserId(request.getUserId(), request.getPriority(),
                dueDate, request.getTaskStatus());
        List<TaskInfoVO> taskInfoVOS = tasks.stream().map(r -> {
            TaskInfoVO taskInfoVO = new TaskInfoVO();
            BeanUtils.copyProperties(r, taskInfoVO);
            return taskInfoVO;
        }).collect(Collectors.toList());
        return RestResponse.success(taskInfoVOS, "Tasks display successfully");
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/registration")
    public RestResponse<Boolean> registration(@RequestBody RegistrationRequest request) {
        if (Objects.isNull(request.getLoginName()) || Objects.isNull(request.getPassword())
                || Objects.isNull(request.getEmail())) {
            return RestResponse.fail(null, "Parameter valid fail");
        }
        Users exist = usersBizMapper.selectByNameOrEmail(request.getLoginName(), request.getEmail());
        if (Objects.nonNull(exist)) {
            return RestResponse.fail(null, "User duplicate");
        }
        Users users = new Users();
        BeanUtils.copyProperties(request, users);
        users.setPasswd(request.getPassword());
        List<Users> insert = new ArrayList<>();
        insert.add(users);
        usersBizMapper.insertBatch(insert);
        return RestResponse.success(true, "Register user successfully");
    }

}
