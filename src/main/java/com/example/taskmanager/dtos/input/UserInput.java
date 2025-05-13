package com.example.taskmanager.dtos.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInput {
    @Email(message = "Email address isn't valid.")
    private String email;

    @Size(min = 4, message = "Password should contains at least 4 characters.")
    private String password;

    @NotBlank(message = "FirstName is required.")
    private String firstName;

    @NotBlank(message = "LastName is required.")
    private String lastName;
}
