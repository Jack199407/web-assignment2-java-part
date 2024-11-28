package com.algonquin.webassignment2.demos.response;

import lombok.Data;

import java.util.Date;
@Data
public class TaskInfoVO {
    private Integer taskId;

    private String taskName;

    private Integer priority;

    private String dueDate;

    private Integer taskStatus;

    private Integer userId;
}
