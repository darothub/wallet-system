package com.example.walletsystem.wallet.infrastructure.entity;

import com.example.walletsystem.user.infrastructure.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "user")
@Entity
@Table(name = "wallets")
public class WalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private UserEntity user;
}
