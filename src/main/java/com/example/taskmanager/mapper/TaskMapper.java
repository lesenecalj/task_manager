package com.example.taskmanager.mapper;

import com.example.taskmanager.dtos.input.TaskInput;
import com.example.taskmanager.dtos.response.TaskOutput;
import com.example.taskmanager.model.TaskModel;

public class TaskMapper {
    public static TaskOutput toOutput(TaskModel taskModel) {
        return TaskOutput.builder()
                .id(taskModel.getId())
                .title(taskModel.getTitle())
                .description(taskModel.getDescription())
                .status(taskModel.getStatus())
                .build();
    }

    public static TaskModel toModel(TaskInput taskInput) {
        return TaskModel.builder()
                .title(taskInput.getTitle())
                .description((taskInput.getDescription()))
                .status(taskInput.getStatus())
                .build();
    }
}
