package com.example.taskmanager.controller;

import com.example.taskmanager.dtos.input.TaskInput;
import com.example.taskmanager.dtos.response.TaskOutput;
import com.example.taskmanager.mapper.TaskMapper;
import com.example.taskmanager.model.TaskModel;
import com.example.taskmanager.model.TaskStatus;
import com.example.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskOutput> getAllTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return taskService.getAllTasks(pageable);
    }

    @GetMapping("/{id}")
    public Optional<TaskOutput> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/status/{status}")
    public List<TaskOutput> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }

    @GetMapping("/users/{userId}")
    public List<TaskOutput> getTasksByStatus(@PathVariable Long userId) {
        return taskService.getTaskByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<TaskOutput> createTask(@Valid @RequestBody TaskInput taskInput) {
        TaskOutput taskOutput = taskService.createTask(taskInput);
        return new ResponseEntity<>(taskOutput, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskOutput> updateTask(@PathVariable Long id, @Valid @RequestBody TaskInput taskInput) {
        return taskService.updateTask(id, taskInput)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
