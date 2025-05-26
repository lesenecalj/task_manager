package io.github.lesenecalj.taskmanager.mapper;

import io.github.lesenecalj.taskmanager.dtos.input.TaskInput;
import io.github.lesenecalj.taskmanager.dtos.response.TaskOutput;
import io.github.lesenecalj.taskmanager.model.TaskModel;
import io.github.lesenecalj.taskmanager.model.UserModel;

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
