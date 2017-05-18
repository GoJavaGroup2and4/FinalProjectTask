package ua.goit.startupserviceapp.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="authorization_token")
public class AuthorizationToken extends AbstractPersistable<Long> {

    private final static Integer DEFAULT_TIME_TO_LIVE_IN_SECONDS = (60 * 60 * 24 * 30); //30 Days

    @Column(length=36)
    private String token;

    private LocalDateTime timeCreated;

    private LocalDateTime expirationDate;

    @JoinColumn(name = "user_id")
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public AuthorizationToken() {}

    public AuthorizationToken(User user) {
        this(user, DEFAULT_TIME_TO_LIVE_IN_SECONDS);
    }

    public AuthorizationToken(User user, Integer timeToLiveInSeconds) {
        this.token = UUID.randomUUID().toString();
        this.user = user;
        this.timeCreated = LocalDateTime.now();
        this.expirationDate = LocalDateTime.now().plusSeconds(timeToLiveInSeconds * 1000L);
    }

    public boolean hasExpired() {
        return this.expirationDate != null && this.expirationDate.isBefore(LocalDateTime.now());
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }
}
