package com.example.walletsystem.user.infrastructure.mapper;

import com.example.walletsystem.user.application.dto.UserResponseDTO;
import com.example.walletsystem.user.domain.UserDomain;
import com.example.walletsystem.user.infrastructure.entity.UserEntity;
import com.example.walletsystem.wallet.infrastructure.mapper.WalletMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "walletEntity.id", target = "walletId")
    UserDomain toDomain(UserEntity entity);
    UserResponseDTO toResponseDTO(UserDomain userDomain);
}
