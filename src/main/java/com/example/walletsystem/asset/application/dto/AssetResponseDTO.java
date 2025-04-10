package com.example.walletsystem.asset.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AssetResponseDTO(
        String symbol,
        BigDecimal quantity,
        BigDecimal price,
        BigDecimal value
) {}
