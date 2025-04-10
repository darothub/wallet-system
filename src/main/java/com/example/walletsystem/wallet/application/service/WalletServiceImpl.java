package com.example.walletsystem.wallet.application.service;

import com.example.walletsystem.asset.application.dto.AssetResponseDTO;
import com.example.walletsystem.wallet.application.dto.WalletResponseDTO;
import com.example.walletsystem.wallet.application.exception.WalletNotFoundException;
import com.example.walletsystem.wallet.domain.WalletDomain;
import com.example.walletsystem.wallet.infrastructure.mapper.WalletMapper;
import com.example.walletsystem.wallet.infrastructure.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Slf4j
@RequiredArgsConstructor
@Service
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;

    @Override
    public WalletResponseDTO getWalletByUserId(Long userId) {
        WalletDomain walletDomain = walletRepository.findByUserId(userId);
        log.info("Get wallet domain : {}", walletDomain);

        if (walletDomain == null) {
            throw new WalletNotFoundException(userId);
        }
        var asset  = walletDomain.getAssetEntities().stream().map(a -> {
            BigDecimal value = a.getQuantity().multiply(a.getPrice());
            return new AssetResponseDTO(a.getSymbol(), a.getQuantity(), a.getPrice(), value);
        }).toList();
        var total = asset.stream().map(AssetResponseDTO::value).reduce(BigDecimal.ZERO, BigDecimal::add);
        log.info("Get wallet : {}", asset);
        WalletResponseDTO walletResponseDTO = walletMapper.toResponseDTO(walletDomain);
        walletResponseDTO.setAssets(asset);
        walletResponseDTO.setTotal(total);
        return walletResponseDTO;
    }
}
