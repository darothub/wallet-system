//package com.example.walletsystem.user.application.service;
//
//import com.example.walletsystem.user.application.dto.UserResponseDTO;
//import com.example.walletsystem.user.application.exception.UserAlreadyExistException;
//import com.example.walletsystem.user.domain.UserDomain;
//import com.example.walletsystem.user.infrastructure.entity.UserEntity;
//import com.example.walletsystem.user.infrastructure.mapper.UserMapper;
//import com.example.walletsystem.user.infrastructure.repository.UserRepository;
//import com.example.walletsystem.wallet.domain.WalletDomain;
//import com.example.walletsystem.wallet.infrastructure.entity.WalletEntity;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import static org.assertj.core.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//class UserServiceImplTest {
//
//    private UserRepository userRepository;
//    private UserServiceImpl userService;
//    private UserMapper userMapper;
//
//    @BeforeEach
//    void setUp() {
//        userRepository = Mockito.mock(UserRepository.class);
//        userMapper = Mockito.mock(UserMapper.class);
//        userService = new UserServiceImpl(userRepository, userMapper);
//    }
//
//    @Test
//    void shouldThrowExceptionWhenUserAlreadyExists() {
//        // Arrange
//        String email = "test@example.com";
//        when(userRepository.findByEmail(email)).thenReturn(new UserDomain());
//
//        // Act & Assert
//        assertThatThrownBy(() -> userService.createUser(email))
//                .isInstanceOf(UserAlreadyExistException.class)
//                .hasMessageContaining("User with email " + email + " already exists");
//
//        verify(userRepository, never()).save(any());
//    }
//
//    @Test
//    void shouldCreateUserWithWalletWhenUserDoesNotExist() {
//        // Arrange
//        String email = "newuser@example.com";
//        Long id = 1L;
//
//        when(userRepository.findByEmail(email)).thenReturn(null);
//
//        UserEntity userEntity = new UserEntity(email);
//        WalletEntity walletEntity = new WalletEntity();
//        walletEntity.setUser(userEntity);
//        userEntity.setWalletEntity(walletEntity);
//
//        UserDomain savedDomain = new UserDomain();
//        savedDomain.setId(id);
//        savedDomain.setEmail(email);
//
//        when(userRepository.save(any(UserEntity.class))).thenReturn(savedDomain);
//
//        UserResponseDTO expectedResponse = new UserResponseDTO(id, userEntity.getWalletEntity().getId());
//        when(userMapper.toResponseDTO(savedDomain)).thenReturn(expectedResponse);
//
//        // Act
//        UserResponseDTO response = userService.createUser(email);
//
//        // Assert
//        assertThat(response).isNotNull();
//        assertThat(response.id()).isEqualTo(id);
//        assertThat(response.walletId()).isEqualTo(userEntity.getWalletEntity().getId());
//
//        verify(userRepository).save(any(UserEntity.class));
//        verify(userMapper).toResponseDTO(savedDomain);
//    }
//}
