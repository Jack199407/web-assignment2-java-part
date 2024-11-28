package com.algonquin.webassignment2.demos.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddTaskRequest {
    private String taskName;

    private Integer priority;

    private LocalDate dueDate;

    private Integer taskStatus;

    private Integer userId;
}
