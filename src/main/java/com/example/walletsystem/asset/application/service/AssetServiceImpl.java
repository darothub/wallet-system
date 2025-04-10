package com.example.walletsystem.asset.application.service;

import com.example.walletsystem.asset.application.dto.AddAssetRequestDTO;
import com.example.walletsystem.asset.application.dto.AssetResponseDTO;
import com.example.walletsystem.asset.application.exception.AssetNotFoundException;
import com.example.walletsystem.asset.application.exception.InvalidAssetPriceException;
import com.example.walletsystem.asset.infrastructure.config.CoinCapApiClient;
import com.example.walletsystem.asset.infrastructure.entity.AssetEntity;
import com.example.walletsystem.asset.infrastructure.mapper.AssetMapper;
import com.example.walletsystem.asset.infrastructure.repository.AssetRepository;
import com.example.walletsystem.user.infrastructure.exception.UserNotFoundException;
import com.example.walletsystem.wallet.application.dto.WalletResponseDTO;
import com.example.walletsystem.wallet.domain.WalletDomain;
import com.example.walletsystem.wallet.infrastructure.entity.WalletEntity;
import com.example.walletsystem.wallet.infrastructure.mapper.WalletMapper;
import com.example.walletsystem.wallet.infrastructure.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Slf4j
@RequiredArgsConstructor
@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final WalletRepository walletRepository;
    private final CoinCapApiClient coinCapApiClient;
    private final WalletMapper walletMapper;
    private final AssetMapper assetMapper;


    @Override
    public List<AssetEntity> findByWalletId(UUID walletId) {
        return assetRepository.findByWalletId(walletId);
    }

    @Transactional
    @Override
    public WalletResponseDTO addAssetToWallet(UUID walletId, AddAssetRequestDTO dto) {
        WalletEntity walletEntity = walletRepository.findById(walletId);
        AssetEntity assetEntity = prepareAssetForWallet(dto.symbol(), dto.quantity(), dto.price());
        assetEntity.setWallet(walletEntity);
        walletEntity.getAssetEntities().add(assetEntity);
        walletEntity = walletRepository.save(walletEntity);
        var asset  = walletEntity.getAssetEntities().stream().map(a ->
                new AssetResponseDTO(a.getSymbol(), a.getQuantity(), a.getPrice(), a.getPrice().multiply(a.getQuantity()))).toList();
        var total = asset.stream().map(AssetResponseDTO::value).reduce(BigDecimal.ZERO, BigDecimal::add);

        var response = new WalletResponseDTO(
                walletEntity.getId(),
                total,
                asset);
        log.info("Add asset to wallet: {}", response);
        return response;
    }

    private AssetEntity prepareAssetForWallet(String symbol, BigDecimal quantity, BigDecimal price) {
        Map<String, BigDecimal> result = coinCapApiClient.getAssetPrice();
        var latestPrice = result.get(symbol);
        if (latestPrice == null || latestPrice.compareTo(price) != 0) {
            throw new InvalidAssetPriceException();
        }
        return new AssetEntity(symbol, quantity, price);
    }
}
