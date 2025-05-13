package com.example.taskmanager.repository;

import com.example.taskmanager.model.TaskModel;
import com.example.taskmanager.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
   List<TaskModel> findByStatus(TaskStatus status);
   List<TaskModel> findByUserId(Long userId);
}
