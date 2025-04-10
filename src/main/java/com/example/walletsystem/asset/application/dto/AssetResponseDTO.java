package com.example.walletsystem.asset.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AssetResponseDTO(
        String symbol,
        BigDecimal quantity,
        BigDecimal price
) {
}
