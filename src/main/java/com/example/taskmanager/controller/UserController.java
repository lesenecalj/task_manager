package com.example.taskmanager.controller;

import com.example.taskmanager.dtos.input.UserInput;
import com.example.taskmanager.dtos.response.UserOutput;
import com.example.taskmanager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserOutput> signUp(@Valid @RequestBody UserInput userInput) {
        System.out.println(userInput);
        UserOutput userFound = userService.signUp(userInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(userFound);
    }

    @GetMapping
    public List<UserOutput> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userService.getUsersByPage(pageable);
    }
}
