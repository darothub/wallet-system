package com.example.walletsystem.asset.infrastructure.repository;

import com.example.walletsystem.asset.infrastructure.entity.AssetEntity;

import java.util.List;
import java.util.UUID;

public interface AssetRepository {
    AssetEntity save(AssetEntity assetEntity);
    List<AssetEntity> findByWalletId(UUID walletId);

}
