package com.example.walletsystem.user.domain;

import com.example.walletsystem.wallet.domain.WalletDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDomain {
    private Long id;
    private String email;
    private UUID walletId;
}
