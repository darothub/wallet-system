package com.example.walletsystem.wallet.application.service;

import com.example.walletsystem.wallet.application.dto.WalletResponseDTO;
import com.example.walletsystem.wallet.domain.WalletDomain;

import java.math.BigDecimal;
import java.util.UUID;

public interface WalletService {
    WalletResponseDTO getWalletByUserId(Long userId);
    void addAssetToWallet(UUID walletId, String symbol, BigDecimal quantity, BigDecimal price);
}
