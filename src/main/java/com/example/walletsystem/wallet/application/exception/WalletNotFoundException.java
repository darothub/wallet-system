package com.example.walletsystem.wallet.application.exception;

public class WalletNotFoundException extends RuntimeException {
    public WalletNotFoundException(Long id) {
        super("Wallet with ID " + id + " not found");
    }
}
