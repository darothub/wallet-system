package com.example.walletsystem.asset.application.service;

import com.example.walletsystem.asset.application.dto.AssetResponseDTO;
import com.example.walletsystem.asset.application.exception.InvalidAssetPriceException;
import com.example.walletsystem.asset.infrastructure.config.CoinCapApiClient;
import com.example.walletsystem.asset.infrastructure.repository.AssetRepository;
import com.example.walletsystem.wallet.domain.WalletDomain;
import com.example.walletsystem.wallet.infrastructure.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final WalletRepository walletRepository;
    private final CoinCapApiClient coinCapApiClient;

    @Override
    public AssetResponseDTO prepareAssetForWallet(Long walletId, String symbol, BigDecimal quantity, BigDecimal price) {
        Map<String, BigDecimal> result = coinCapApiClient.getAssetPrice();
        var latestPrice = result.get(symbol);
        if (latestPrice == null || latestPrice.compareTo(price) != 0) {
            throw new InvalidAssetPriceException();
        }
        return new AssetResponseDTO(symbol, quantity, price);
    }
}
