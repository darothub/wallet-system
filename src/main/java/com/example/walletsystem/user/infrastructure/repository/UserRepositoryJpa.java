package com.example.walletsystem.user.infrastructure.repository;

import com.example.walletsystem.user.domain.UserDomain;
import com.example.walletsystem.user.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
