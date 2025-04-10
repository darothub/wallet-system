package com.example.walletsystem.user.application.service;

import com.example.walletsystem.user.application.dto.UserResponseDTO;
import com.example.walletsystem.user.domain.UserDomain;

public interface UserService {
    UserResponseDTO createUser(String email);
}
