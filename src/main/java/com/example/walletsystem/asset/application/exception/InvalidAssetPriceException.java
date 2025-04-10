package com.example.walletsystem.asset.application.exception;

public class InvalidAssetPriceException extends RuntimeException {
    public InvalidAssetPriceException() {
        super("Invalid asset price");
    }
}
