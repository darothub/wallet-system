package com.example.walletsystem.asset.infrastructure.respomse;

import lombok.Data;

import java.util.List;


public record CoinCapApiResponse(
        List<CoinCapApiAssetDTO> data
){}
