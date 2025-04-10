package com.example.walletsystem.wallet.application.dto;

import com.example.walletsystem.asset.application.dto.AssetResponseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
public class WalletResponseDTO{
    private UUID id;
    private BigDecimal total;
    private List<AssetResponseDTO> assets;
}
