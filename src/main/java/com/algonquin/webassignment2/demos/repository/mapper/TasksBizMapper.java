package com.algonquin.webassignment2.demos.repository.mapper;


import com.algonquin.webassignment2.demos.repository.model.Tasks;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TasksBizMapper {
    List<Tasks> listByUserId(@Param("userId") Integer userId, @Param("priorities") List<Integer> priorities,
                             @Param("dueDate") LocalDateTime dueDate, @Param("taskStatus") List<Integer> taskStatus);

    void insertBatch(@Param("tasks") List<Tasks> tasks);

    Tasks selectLastOne();
}