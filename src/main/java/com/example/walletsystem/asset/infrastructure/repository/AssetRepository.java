package com.example.walletsystem.asset.infrastructure.repository;

import com.example.walletsystem.asset.infrastructure.entity.AssetEntity;
import com.example.walletsystem.asset.domain.AssetDomain;

public interface AssetRepository {
    AssetDomain addAssetToWallet(AssetEntity assetEntity);
}
