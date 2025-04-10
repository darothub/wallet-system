package com.example.walletsystem.wallet.domain;

import com.example.walletsystem.asset.domain.AssetDomain;
import com.example.walletsystem.asset.infrastructure.entity.AssetEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletDomain {
    private UUID id;
    private Long userId;
    private List<AssetDomain> assetEntities = new ArrayList<>();
}
