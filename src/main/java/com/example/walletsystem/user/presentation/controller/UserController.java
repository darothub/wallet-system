package com.example.walletsystem.user.presentation.controller;

import com.example.walletsystem.user.application.dto.CreateUserDTO;
import com.example.walletsystem.user.application.dto.UserResponseDTO;
import com.example.walletsystem.user.application.service.UserService;
import com.example.walletsystem.user.presentation.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserResponseDTO> createUser(@Valid @RequestBody CreateUserDTO createUserDTO) {
        UserResponseDTO createdUser = userService.createUser(createUserDTO.email());
        return new ApiResponse<>(createdUser);
    }
}
