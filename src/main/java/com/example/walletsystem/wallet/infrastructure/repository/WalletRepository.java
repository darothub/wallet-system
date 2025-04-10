package com.example.walletsystem.wallet.infrastructure.repository;

import com.example.walletsystem.wallet.domain.WalletDomain;

public interface WalletRepository {
    WalletDomain findByUserId(Long id);
}
