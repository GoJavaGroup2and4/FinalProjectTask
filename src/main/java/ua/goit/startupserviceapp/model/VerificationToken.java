package ua.goit.startupserviceapp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "verification_token")
public class VerificationToken extends BaseEntity {

    private static final int DEFAULT_EXPIRY_TIME_IN_MINS = 60 * 24; //24 hours

    @Column(length=36)
    private String token;

    private LocalDate expiryDate;

    @Enumerated(EnumType.STRING)
    private VerificationTokenType tokenType;

    private boolean verified;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserDB user;

    public VerificationToken() {
        this.token = UUID.randomUUID().toString();
        this.expiryDate = calculateExpiryDate(DEFAULT_EXPIRY_TIME_IN_MINS);
    }

    public VerificationToken(UserDB user, VerificationTokenType tokenType, int expirationTimeInMinutes) {
        this.user = user;
        this.tokenType = tokenType;
        this.expiryDate = calculateExpiryDate(expirationTimeInMinutes);
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDB getUser() {
        return user;
    }

    public void setUser(UserDB user) {
        this.user = user;
    }

    public VerificationTokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(VerificationTokenType tokenType) {
        this.tokenType = tokenType;
    }

    private LocalDate calculateExpiryDate(long expiryTimeInMinutes) {
        return LocalDateTime.now().plusMinutes(expiryTimeInMinutes).toLocalDate();
    }

    public boolean hasExpired() {
        return getExpiryDate().isBefore(LocalDate.now());
    }
}
