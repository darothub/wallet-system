package com.example.walletsystem.asset.infrastructure.repository;

import com.example.walletsystem.asset.infrastructure.entity.AssetEntity;
import com.example.walletsystem.asset.infrastructure.mapper.AssetMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Repository
public class AssetRepositoryImpl implements AssetRepository {

    private final AssetRepositoryJpa assetRepositoryJpa;
    private final AssetMapper assetMapper;



    @Override
    public AssetEntity save(AssetEntity assetEntity) {
        return null;
    }

    @Override
    public List<AssetEntity> findByWalletId(UUID walletId) {
        return assetRepositoryJpa.findByWallet_Id(walletId);
    }
}
