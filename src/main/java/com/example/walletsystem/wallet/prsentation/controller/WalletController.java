package com.example.walletsystem.wallet.prsentation.controller;

import com.example.walletsystem.asset.application.dto.AddAssetRequestDTO;
import com.example.walletsystem.asset.application.service.AssetService;
import com.example.walletsystem.shared.response.ApiResponse;
import com.example.walletsystem.wallet.application.dto.WalletResponseDTO;
import com.example.walletsystem.wallet.application.service.WalletService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/wallets")
@Validated
public class WalletController {

    private final WalletService walletService;
    private final AssetService assetService;

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<?> getWalletByUserId(@PathVariable Long userId) {
        WalletResponseDTO walletResponseDTO = walletService.getWalletByUserId(userId);
        return ApiResponse.of(walletResponseDTO);
    }

    @PostMapping("/{walletId}/assets")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<?> addAssetToWallet(
            @PathVariable UUID walletId,
            @Valid @RequestBody AddAssetRequestDTO addAssetRequest) {
        WalletResponseDTO walletResponseDTO = assetService.addAssetToWallet(walletId, addAssetRequest);
        return ApiResponse.of(walletResponseDTO);
    }
}
