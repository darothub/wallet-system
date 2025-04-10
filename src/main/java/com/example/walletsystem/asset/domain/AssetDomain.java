package com.example.walletsystem.asset.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
public class AssetDomain {
    private UUID id;
    private String symbol;
    private BigDecimal quantity;
    private BigDecimal price;
    private UUID walletId;
}
