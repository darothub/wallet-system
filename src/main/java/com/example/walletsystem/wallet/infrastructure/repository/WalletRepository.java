package com.example.walletsystem.wallet.infrastructure.repository;

import com.example.walletsystem.wallet.domain.WalletDomain;
import com.example.walletsystem.wallet.infrastructure.entity.WalletEntity;

import java.util.UUID;

public interface WalletRepository {
    WalletDomain findByUserId(Long id);
    WalletDomain findById(UUID walletId);
    WalletDomain save(WalletEntity walletEntity);
}
