//package com.example.walletsystem.user.infrastructure.repository;
//
//import com.example.walletsystem.user.domain.UserDomain;
//import com.example.walletsystem.user.infrastructure.entity.UserEntity;
//import com.example.walletsystem.user.infrastructure.mapper.UserMapper;
//import com.example.walletsystem.user.infrastructure.mapper.UserMapperImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import static org.assertj.core.api.Assertions.*;
//
//@DataJpaTest
//@ActiveProfiles("test")
//class UserAssetRepositoryImplIntegrationTest {
//
//    private UserRepositoryImpl userRepositoryImpl;
//
//    @Autowired
//    private UserRepositoryJpa userRepositoryJpa;
//
//    private UserMapper userMapper = new UserMapperImpl();
//
//    @BeforeEach
//    void setUp() {
//        userRepositoryImpl = new UserRepositoryImpl(userRepositoryJpa, userMapper);
//    }
//
//    @Test
//    void shouldSaveAndReturnUserDomain() {
//        // Arrange
//        String email = "saved@example.com";
//        UserEntity entity = new UserEntity(email);
//
//        // Act
////        UserDomain saved = userRepositoryImpl.save(entity);
//
////        // Assert
////        assertThat(saved).isNotNull();
////        assertThat(saved.getEmail()).isEqualTo(email);
//    }
//
//    @Test
//    void shouldFindUserByEmail() {
//        // Arrange
//        String email = "findme@example.com";
//        userRepositoryJpa.save(new UserEntity(email));
//
//        // Act
//        UserDomain found = userRepositoryImpl.findByEmail(email);
//
//        // Assert
//        assertThat(found).isNotNull();
//        assertThat(found.getEmail()).isEqualTo(email);
//    }
//
//    @Test
//    void shouldReturnNullWhenUserNotFoundInFindByEmail() {
//        // Act
//        UserDomain found = userRepositoryImpl.findByEmail("nonexistent@example.com");
//
//        // Assert
//        assertThat(found).isNull();
//    }
//
//}
