package com.example.walletsystem.asset.infrastructure.repository;

import com.example.walletsystem.asset.infrastructure.entity.AssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AssetRepositoryJpa extends JpaRepository<AssetEntity, UUID> {
    List<AssetEntity> findByWallet_Id(UUID walletId);
}
