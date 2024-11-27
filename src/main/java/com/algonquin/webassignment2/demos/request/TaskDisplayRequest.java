package com.algonquin.webassignment2.demos.request;

import lombok.Data;

import java.util.List;

@Data
public class TaskDisplayRequest {
    private Integer userId;
    private List<Integer> priority;
    private String dueDate;
    private List<Integer> taskStatus;
}
