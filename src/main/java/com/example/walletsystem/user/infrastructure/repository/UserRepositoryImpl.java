package com.example.walletsystem.user.infrastructure.repository;

import com.example.walletsystem.user.domain.UserDomain;
import com.example.walletsystem.user.infrastructure.entity.UserEntity;
import com.example.walletsystem.user.infrastructure.exception.UserNotFoundException;
import com.example.walletsystem.user.infrastructure.mapper.UserMapper;
import com.example.walletsystem.wallet.infrastructure.mapper.WalletMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserRepositoryJpa userRepositoryJpa;
    private final UserMapper userMapper;

    @Override
    public UserDomain findByEmail(String email) {
        Optional<UserEntity> userEntity  = userRepositoryJpa.findByEmail(email);
        return userEntity.map(userMapper::toDomain).orElse(null);
    }


    @Override
    public UserDomain save(UserEntity userEntity) {
        UserEntity savedUserEntity = userRepositoryJpa.save(userEntity);
        log.info("Saved user: {}", savedUserEntity);
        return userMapper.toDomain(savedUserEntity);
    }

}
