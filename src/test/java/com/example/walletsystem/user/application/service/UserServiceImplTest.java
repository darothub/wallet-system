package com.example.walletsystem.user.application.service;

import com.example.walletsystem.user.application.dto.UserResponseDTO;
import com.example.walletsystem.user.application.exception.UserAlreadyExistException;
import com.example.walletsystem.user.domain.UserDomain;
import com.example.walletsystem.user.infrastructure.entity.UserEntity;
import com.example.walletsystem.user.infrastructure.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    private UserRepository userRepository;
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void shouldThrowExceptionWhenUserAlreadyExists() {
        // Arrange
        String email = "test@example.com";
        when(userRepository.findByEmail(email)).thenReturn(new UserDomain());

        // Act & Assert
        assertThatThrownBy(() -> userService.createUser(email))
                .isInstanceOf(UserAlreadyExistException.class)
                .hasMessageContaining("User with email " + email + " already exists");

        verify(userRepository, never()).save(any());
    }

    @Test
    void shouldCreateUserWhenUserDoesNotExist() {
        // Arrange
        String email = "newuser@example.com";
        Long id = 1L;
        when(userRepository.findByEmail(email)).thenReturn(null);

        UserDomain savedUser = new UserDomain();
        savedUser.setEmail(email);
        savedUser.setId(id);
        when(userRepository.save(any(UserEntity.class))).thenReturn(savedUser);

        // Act
        UserResponseDTO response = userService.createUser(email);

        // Assert
        assertThat(response).isNotNull();
        assertThat(response.id()).isEqualTo(id);
        verify(userRepository).save(any(UserEntity.class));
    }
}
