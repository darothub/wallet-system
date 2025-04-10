package com.example.walletsystem.wallet.infrastructure.repository;

import com.example.walletsystem.wallet.infrastructure.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WalletRepositoryJpa extends JpaRepository<WalletEntity, UUID> {
    WalletEntity findByUser_Id(Long userEntityId);
}
