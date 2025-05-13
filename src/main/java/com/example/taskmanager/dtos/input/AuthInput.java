package com.example.taskmanager.dtos.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthInput {
    @Email()
    private String email;
    @NotNull()
    private String password;
}