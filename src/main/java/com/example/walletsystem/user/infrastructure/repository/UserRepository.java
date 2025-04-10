package com.example.walletsystem.user.infrastructure.repository;

import com.example.walletsystem.user.domain.UserDomain;
import com.example.walletsystem.user.infrastructure.entity.UserEntity;

import java.util.Optional;

public interface UserRepository {
    UserDomain findByEmail(String email);
    UserDomain save(UserEntity userEntity);

}
