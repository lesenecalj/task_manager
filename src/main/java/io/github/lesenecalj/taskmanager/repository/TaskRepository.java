package io.github.lesenecalj.taskmanager.repository;

import io.github.lesenecalj.taskmanager.model.TaskModel;
import io.github.lesenecalj.taskmanager.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
   List<TaskModel> findByStatus(TaskStatus status);
   List<TaskModel> findByUserId(Long userId);
}
