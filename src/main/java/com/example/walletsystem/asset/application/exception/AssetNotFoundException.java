package com.example.walletsystem.asset.application.exception;

public class AssetNotFoundException extends RuntimeException {
    public AssetNotFoundException() {
        super("Asset not found");
    }
}
