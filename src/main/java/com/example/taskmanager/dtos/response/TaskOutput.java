package com.example.taskmanager.dtos.response;

import com.example.taskmanager.model.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskOutput {

    @NotNull()
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    private String description;

    @NotNull(message = "UserId must be defined")
    private Long userId;

    @Email(message = "User email must be in a valid format")
    private String userEmail;

    @NotNull(message = "Status is mandatory")
    private TaskStatus status;
}

