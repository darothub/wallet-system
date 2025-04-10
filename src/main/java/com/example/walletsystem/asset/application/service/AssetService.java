package com.example.walletsystem.asset.application.service;

import com.example.walletsystem.asset.application.dto.AssetResponseDTO;

import java.math.BigDecimal;

public interface AssetService {
    AssetResponseDTO prepareAssetForWallet(Long walletId, String symbol, BigDecimal quantity, BigDecimal price);
}
