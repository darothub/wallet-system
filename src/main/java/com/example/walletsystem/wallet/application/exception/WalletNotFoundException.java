package com.example.walletsystem.wallet.application.exception;

import java.util.UUID;

public class WalletNotFoundException extends RuntimeException {
    public WalletNotFoundException(Long id) {
        super("Wallet with ID " + id + " not found");
    }
    public WalletNotFoundException(UUID id) {
        super("Wallet with ID " + id + " not found");
    }
}
