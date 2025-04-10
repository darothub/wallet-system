package com.example.walletsystem.wallet.application.service;

import com.example.walletsystem.wallet.application.dto.WalletResponseDTO;
import com.example.walletsystem.wallet.application.exception.WalletNotFoundException;
import com.example.walletsystem.wallet.domain.WalletDomain;
import com.example.walletsystem.wallet.infrastructure.mapper.WalletMapper;
import com.example.walletsystem.wallet.infrastructure.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;

    @Override
    public WalletResponseDTO getWalletByUserId(Long userId) {
        WalletDomain walletDomain = walletRepository.findByUserId(userId);
        if (walletDomain == null) {
            throw new WalletNotFoundException(userId);
        }
        return walletMapper.toResponseDTO(walletDomain);
    }
}
