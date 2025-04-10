package com.example.walletsystem.user.application.dto;

import jakarta.validation.constraints.Email;

public record CreateUserDTO(
        @Email(message = "Invalid email format")
        String email
) { }
