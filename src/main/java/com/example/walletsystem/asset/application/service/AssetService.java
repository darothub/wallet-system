package com.example.walletsystem.asset.application.service;

import com.example.walletsystem.asset.application.dto.AddAssetRequestDTO;
import com.example.walletsystem.asset.infrastructure.entity.AssetEntity;
import com.example.walletsystem.wallet.application.dto.WalletResponseDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface AssetService {
    List<AssetEntity> findByWalletId(UUID walletId);
    WalletResponseDTO addAssetToWallet(UUID walletId, AddAssetRequestDTO dto);
}
