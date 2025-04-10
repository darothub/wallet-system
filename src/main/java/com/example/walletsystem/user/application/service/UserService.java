package com.example.walletsystem.user.application.service;

import com.example.walletsystem.user.application.dto.UserResponseDTO;
import com.example.walletsystem.user.domain.UserDomain;
import com.example.walletsystem.user.infrastructure.entity.UserEntity;

public interface UserService {
    UserResponseDTO createUser(String email);
    UserEntity getUserById(Long id);
}
