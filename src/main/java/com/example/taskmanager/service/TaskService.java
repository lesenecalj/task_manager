package com.example.taskmanager.service;

import com.example.taskmanager.dtos.input.TaskInput;
import com.example.taskmanager.dtos.response.TaskOutput;
import com.example.taskmanager.mapper.TaskMapper;
import com.example.taskmanager.model.TaskModel;
import com.example.taskmanager.model.TaskStatus;

import com.example.taskmanager.model.UserModel;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<TaskOutput> getAllTasks(Pageable pageable) {
        logger.info("getAllTasks");
        return taskRepository.findAll(pageable).getContent().stream()
            .map(TaskMapper::toOutput)
            .collect(Collectors.toList());
    }

    public Optional<TaskOutput> getTaskById(Long id) {
        logger.info("getTaskById by [{}]", id);
        return taskRepository.findById(id)
                .map(TaskMapper::toOutput);
    }

    public List<TaskOutput> getTaskByUserId(Long userId) {
        logger.info("getTaskByUserId by [{}]", userId);
        return taskRepository.findByUserId(userId).stream()
                .map(TaskMapper::toOutput).collect(Collectors.toList());
    }

    public List<TaskOutput> getTasksByStatus(TaskStatus status) {
        logger.info("getTasksByStatus by [{}]", status);
        return taskRepository.findByStatus(status).stream()
                .map(TaskMapper::toOutput)
                .collect(Collectors.toList());
    }

    public TaskOutput createTask(TaskInput taskInput) {
        logger.info("createTask with [{}]", taskInput);
        UserModel user = userRepository.findById(taskInput.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + taskInput.getUserId()));
        TaskModel taskModel = TaskMapper.toModel(taskInput, user);
        taskRepository.save(taskModel);
        return TaskMapper.toOutput(taskModel);
    }

    /** todo: handle user update **/
    public Optional<TaskOutput> updateTask(Long id, TaskInput taskInput) {
        return taskRepository.findById(id).map(existingTask -> {
            existingTask.setTitle(taskInput.getTitle());
            existingTask.setDescription(taskInput.getDescription());
            existingTask.setStatus(taskInput.getStatus());
            return taskRepository.save(existingTask);
        })
                .map(TaskMapper::toOutput);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
