package com.example.walletsystem.asset.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AddAssetRequestDTO(
        @NotNull(message = "Symbol is missing")
        @NotBlank(message = "Symbol cannot be blank")
        String symbol,
        @NotNull(message = "Quantity is missing")
        BigDecimal quantity,
        @NotNull(message = "Price is missing")
        BigDecimal price
) { }
