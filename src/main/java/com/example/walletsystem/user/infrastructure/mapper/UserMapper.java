package com.example.walletsystem.user.infrastructure.mapper;

import com.example.walletsystem.user.domain.UserDomain;
import com.example.walletsystem.user.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDomain toDomain(UserEntity entity);
}
