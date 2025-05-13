package com.example.taskmanager.dtos.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOutput {

    private Long id;

    @Email(message = "Email address isn't valid.")
    private String email;

    @NotBlank(message = "FirstName is required.")
    private String firstName;

    @NotBlank(message = "LastName is required.")
    private String lastName;
}
