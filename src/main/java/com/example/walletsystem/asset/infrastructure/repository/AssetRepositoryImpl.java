package com.example.walletsystem.asset.infrastructure.repository;

import com.example.walletsystem.asset.infrastructure.entity.AssetEntity;
import com.example.walletsystem.asset.domain.AssetDomain;
import com.example.walletsystem.asset.infrastructure.mapper.AssetMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class AssetRepositoryImpl implements AssetRepository {

    private final AssetRepositoryJpa assetRepositoryJpa;
    private final AssetMapper assetMapper;
    @Override
    public AssetDomain addAssetToWallet(AssetEntity assetEntity) {
        AssetEntity saved = assetRepositoryJpa.save(assetEntity);
        return assetMapper.toDomain(saved);
    }
}
