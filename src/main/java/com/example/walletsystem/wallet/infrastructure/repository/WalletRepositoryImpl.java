package com.example.walletsystem.wallet.infrastructure.repository;

import com.example.walletsystem.wallet.application.exception.WalletNotFoundException;
import com.example.walletsystem.wallet.domain.WalletDomain;
import com.example.walletsystem.wallet.infrastructure.entity.WalletEntity;
import com.example.walletsystem.wallet.infrastructure.mapper.WalletMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class WalletRepositoryImpl implements WalletRepository {
    private final WalletRepositoryJpa walletRepositoryJpa;
    private final WalletMapper walletMapper;
    @Override
    public WalletDomain findByUserId(Long id) {
        WalletEntity walletEntity = walletRepositoryJpa.findByUser_Id(id);
        return walletMapper.toDomain(walletEntity);
    }

    @Override
    public WalletDomain findById(UUID walletId) {
        return walletRepositoryJpa.findById(walletId)
                .map(walletMapper::toDomain)
                .orElseThrow(() -> new WalletNotFoundException(walletId));
    }

    @Override
    public WalletDomain save(WalletEntity walletEntity) {
        return walletMapper.toDomain(walletRepositoryJpa.save(walletEntity));
    }

}
