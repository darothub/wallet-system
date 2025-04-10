package com.example.walletsystem.wallet.application.service;

import com.example.walletsystem.asset.application.service.AssetService;
import com.example.walletsystem.user.application.service.UserService;
import com.example.walletsystem.wallet.application.dto.WalletResponseDTO;
import com.example.walletsystem.wallet.application.exception.WalletNotFoundException;
import com.example.walletsystem.wallet.domain.WalletDomain;
import com.example.walletsystem.wallet.infrastructure.entity.WalletEntity;
import com.example.walletsystem.wallet.infrastructure.mapper.WalletMapper;
import com.example.walletsystem.wallet.infrastructure.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;
    private final AssetService assetService;
    private final UserService userService;

    @Override
    public WalletResponseDTO getWalletByUserId(Long userId) {
        WalletDomain walletDomain = walletRepository.findByUserId(userId);
        if (walletDomain == null) {
            throw new WalletNotFoundException(userId);
        }
        return walletMapper.toResponseDTO(walletDomain);
    }




    @Transactional
    @Override
    public void addAssetToWallet(UUID walletId, String symbol, BigDecimal quantity, BigDecimal price) {
        WalletDomain walletDomain = walletRepository.findById(walletId);
        WalletEntity walletEntity = walletMapper.toEntity(walletDomain);


    }
}
