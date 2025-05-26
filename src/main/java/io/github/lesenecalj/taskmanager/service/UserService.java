package io.github.lesenecalj.taskmanager.service;

import io.github.lesenecalj.taskmanager.dtos.input.UserInput;
import io.github.lesenecalj.taskmanager.dtos.response.UserOutput;
import io.github.lesenecalj.taskmanager.mapper.UserMapper;
import io.github.lesenecalj.taskmanager.model.UserModel;
import io.github.lesenecalj.taskmanager.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserModel createUser(UserInput user) {
        logger.info("createUser with [{}]", user);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(UserMapper.toModel(user));
    }

    public Optional<UserOutput> getUserById(Long id) {
        logger.info("getTaskById by [{}]", id);
        return userRepository.findById(id)
                .map(UserMapper::toOutput);
    }

    public List<UserModel> getAllUsers(Pageable pageable) {
        logger.info("getAllUsers");
        return userRepository.findAll(pageable).getContent();
    }

    public Optional<UserModel> getUserByEmail(String email) {
        logger.info("getUserByEmail {}", email);
        return userRepository.findByEmail(email);
    }

    public UserOutput signUp(UserInput userInput) {
        logger.info("signUp with input: {}", userInput);
        Optional<UserModel> userFound = this.getUserByEmail(userInput.getEmail());
        if (userFound.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already in use");
        }
        UserModel userModel = this.createUser(userInput);
        return UserMapper.toOutput(userModel);
    }

    public List<UserOutput> getUsersByPage(Pageable pageable) {
        logger.info("getUsersByPage, {}", pageable);
        List<UserModel> users = this.getAllUsers(pageable);
        return users.stream()
                .map(UserMapper::toOutput)
                .collect(Collectors.toList());
    }
}
