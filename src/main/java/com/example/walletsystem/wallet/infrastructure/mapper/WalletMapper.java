package com.example.walletsystem.wallet.infrastructure.mapper;

import com.example.walletsystem.wallet.application.dto.WalletResponseDTO;
import com.example.walletsystem.wallet.domain.WalletDomain;
import com.example.walletsystem.wallet.infrastructure.entity.WalletEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WalletMapper {
    @Mapping(source = "user.id", target = "userId")
    WalletDomain toDomain(WalletEntity walletEntity);
    @Mapping(target = "total", ignore = true)
    WalletResponseDTO toResponseDTO(WalletDomain walletDomain);
}
