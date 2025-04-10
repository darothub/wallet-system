package com.example.walletsystem.user.application.service;

import com.example.walletsystem.user.application.dto.UserResponseDTO;
import com.example.walletsystem.user.application.exception.UserAlreadyExistException;
import com.example.walletsystem.user.domain.UserDomain;
import com.example.walletsystem.user.infrastructure.entity.UserEntity;
import com.example.walletsystem.user.infrastructure.mapper.UserMapper;
import com.example.walletsystem.user.infrastructure.repository.UserRepository;
import com.example.walletsystem.wallet.infrastructure.entity.WalletEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponseDTO createUser(String email) {
        if (userRepository.findByEmail(email) != null) {
            throw new UserAlreadyExistException(email);
        }
        UserEntity userEntity = new UserEntity(email);
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setUser(userEntity);
        userEntity.setWalletEntity(walletEntity);
        UserDomain userDomain = userRepository.save(userEntity);
        log.info("Created user with email {}, {}", walletEntity, userDomain);
        return userMapper.toResponseDTO(userDomain);
    }
}
