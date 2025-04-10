package com.example.walletsystem.wallet.prsentation.controller;

import com.example.walletsystem.shared.response.ApiResponse;
import com.example.walletsystem.wallet.application.dto.WalletResponseDTO;
import com.example.walletsystem.wallet.application.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/wallets")
@Validated
public class WalletController {

    private final WalletService walletService;

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<?> getWalletByUserId(@PathVariable Long userId) {
        WalletResponseDTO walletResponseDTO = walletService.getWalletByUserId(userId);
        return ApiResponse.of(walletResponseDTO);
    }
}
