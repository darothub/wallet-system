package com.example.walletsystem.wallet.application.dto;

import java.util.UUID;

public record WalletResponseDTO(
        UUID id,
        Long userId
) { }
