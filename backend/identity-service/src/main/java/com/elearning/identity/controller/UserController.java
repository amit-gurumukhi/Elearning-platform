package com.elearning.identity.controller;

import com.elearning.identity.dto.CreateUserRequest;
import com.elearning.identity.dto.UserResponse;
import com.elearning.identity.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(
            @Valid @RequestBody CreateUserRequest request) {

        return userService.createUser(
                request.getEmail(),
                request.getPassword()
        );
    }
}