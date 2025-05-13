package com.example.taskmanager.mapper;

import com.example.taskmanager.dtos.input.TaskInput;
import com.example.taskmanager.dtos.response.TaskOutput;
import com.example.taskmanager.model.TaskModel;
import com.example.taskmanager.model.UserModel;
import com.example.taskmanager.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;

public class TaskMapper {
    public static TaskOutput toOutput(TaskModel taskModel) {
        return TaskOutput.builder()
                .id(taskModel.getId())
                .title(taskModel.getTitle())
                .description(taskModel.getDescription())
                .status(taskModel.getStatus())
                .userId(taskModel.getUser() != null ? taskModel.getUser().getId() : null)
                .userEmail(taskModel.getUser() != null ? taskModel.getUser().getEmail() : null)
                .build();
    }

    public static TaskModel toModel(TaskInput taskInput, UserModel userModel) {
        return TaskModel.builder()
                .title(taskInput.getTitle())
                .description((taskInput.getDescription()))
                .status(taskInput.getStatus())
                .user(userModel)
                .build();
    }

}
