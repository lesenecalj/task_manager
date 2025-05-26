package io.github.lesenecalj.taskmanager.mapper;

import io.github.lesenecalj.taskmanager.dtos.input.UserInput;
import io.github.lesenecalj.taskmanager.dtos.response.UserOutput;
import io.github.lesenecalj.taskmanager.model.UserModel;

public class UserMapper {
    public static UserOutput toOutput(UserModel user) {
        return UserOutput.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public static UserModel toModel(UserInput userInput) {
        return UserModel.builder()
                .email(userInput.getEmail())
                .password(userInput.getPassword())
                .firstName(userInput.getFirstName())
                .lastName(userInput.getLastName())
                .build();
    }
}
