package io.github.lesenecalj.taskmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 30, message = "Title must not exceed 30 characters")
    private String title;

    @Size(min = 5, message = "Description must exceed 5 characters")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY) // Define the relationship type (Many Tasks to One User)
    @JoinColumn(name = "user_id")     // Specify the foreign key column name in the tasks table
    private UserModel user;

    @NotNull(message = "Status must not be null")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
