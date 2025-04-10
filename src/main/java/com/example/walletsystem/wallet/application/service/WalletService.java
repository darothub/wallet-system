package com.example.walletsystem.wallet.application.service;

import com.example.walletsystem.wallet.application.dto.WalletResponseDTO;
import com.example.walletsystem.wallet.domain.WalletDomain;

public interface WalletService {
    WalletResponseDTO getWalletByUserId(Long userId);
}
