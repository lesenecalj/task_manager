package io.github.lesenecalj.taskmanager.repository;

import io.github.lesenecalj.taskmanager.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);
}
