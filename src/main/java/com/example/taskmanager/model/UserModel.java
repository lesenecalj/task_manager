package com.example.taskmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Email(message = "Email address isn't valid.")
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(min = 4, message = "Password should contains at least 4 characters.")
    private String password;

    @NotBlank(message = "FirstName is required.")
    private String firstName;

    @NotBlank(message = "LastName is required.")
    private String lastName;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
