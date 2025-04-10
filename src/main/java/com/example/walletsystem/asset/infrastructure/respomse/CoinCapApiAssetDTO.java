package com.example.walletsystem.asset.infrastructure.respomse;

import java.math.BigDecimal;

public record CoinCapApiAssetDTO(
        String symbol,
        BigDecimal priceUsd
) {}
