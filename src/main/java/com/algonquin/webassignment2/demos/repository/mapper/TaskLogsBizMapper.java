package com.algonquin.webassignment2.demos.repository.mapper;

import com.algonquin.webassignment2.demos.repository.model.TaskLogs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskLogsBizMapper {
    void insertBatch(@Param("logs") List<TaskLogs> logs);
}