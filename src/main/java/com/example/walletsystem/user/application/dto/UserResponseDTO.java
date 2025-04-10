package com.example.walletsystem.user.application.dto;

import java.util.UUID;

public record UserResponseDTO(
        Long id,
        UUID walletId
){}
