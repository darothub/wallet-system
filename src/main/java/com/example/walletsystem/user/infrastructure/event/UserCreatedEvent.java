package com.example.walletsystem.user.infrastructure.event;

import org.springframework.context.ApplicationEvent;

import java.util.UUID;

public class UserCreatedEvent extends ApplicationEvent {

    private Long userId;
    private UUID walletId;

    public UserCreatedEvent(Object source, Long userId, UUID walletId) {
        super(source);
        this.userId = userId;
        this.walletId = walletId;
    }

    public Long getUserId() {
        return userId;
    }

    public UUID getWalletId() {
        return walletId;
    }
}