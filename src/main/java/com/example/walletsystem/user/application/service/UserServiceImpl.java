package com.example.walletsystem.user.application.service;

import com.example.walletsystem.user.application.dto.UserResponseDTO;
import com.example.walletsystem.user.application.exception.UserAlreadyExistException;
import com.example.walletsystem.user.domain.UserDomain;
import com.example.walletsystem.user.infrastructure.entity.UserEntity;
import com.example.walletsystem.user.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserResponseDTO createUser(String email) {
        if (userRepository.findByEmail(email) != null) {
            throw new UserAlreadyExistException("User with email " + email + " already exists");
        }
        UserEntity userEntity = new UserEntity(email);
        UserDomain userDomain = userRepository.save(userEntity);
        return new UserResponseDTO(userDomain.getId());
    }
}
