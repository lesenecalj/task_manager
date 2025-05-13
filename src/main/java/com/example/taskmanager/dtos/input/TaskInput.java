package com.example.taskmanager.dtos.input;

import com.example.taskmanager.model.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskInput {

    @NotBlank(message = "Title is mandatory")
    private String title;

    private String description;

    private Long userId;

    @NotNull(message = "Status is mandatory")
    private TaskStatus status;
}
