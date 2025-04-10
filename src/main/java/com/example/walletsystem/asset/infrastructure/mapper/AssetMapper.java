package com.example.walletsystem.asset.infrastructure.mapper;

import com.example.walletsystem.asset.infrastructure.entity.AssetEntity;
import com.example.walletsystem.asset.domain.AssetDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssetMapper {
    AssetDomain toDomain(AssetEntity assetEntity);
}
