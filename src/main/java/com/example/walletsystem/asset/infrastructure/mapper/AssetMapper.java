package com.example.walletsystem.asset.infrastructure.mapper;

import com.example.walletsystem.asset.application.dto.AssetResponseDTO;
import com.example.walletsystem.asset.infrastructure.entity.AssetEntity;
import com.example.walletsystem.asset.domain.AssetDomain;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssetMapper {
    AssetDomain toDomain(AssetEntity assetEntity);

    @InheritInverseConfiguration
    AssetEntity toEntity(AssetDomain domain);

    AssetResponseDTO toDto(AssetEntity assetEntity);
}
