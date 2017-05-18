package ua.goit.startupserviceapp.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table (name = "users")
public class User extends BaseEntity {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String emailAddress;

    private boolean isVerified;

    @OneToMany(mappedBy="user",
               targetEntity=VerificationToken.class,
               cascade= CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<VerificationToken> verificationTokens = new ArrayList<VerificationToken>();

    @OneToOne(fetch = FetchType.LAZY,
              mappedBy = "user",
              cascade = CascadeType.ALL)
    private AuthorizationToken authorizationToken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        this.isVerified = verified;
    }

    public synchronized void addVerificationToken(VerificationToken token) {
        this.verificationTokens.add(token);
    }

    public synchronized List<VerificationToken> getVerificationTokens() {
        return Collections.unmodifiableList(this.verificationTokens);
    }

    public synchronized void setAuthorizationToken(AuthorizationToken token) {


        this.authorizationToken = token;
    }

    public synchronized AuthorizationToken getAuthorizationToken() {
        return authorizationToken;
    }

    public VerificationToken getActiveLostPasswordToken() {
        return getActiveToken(VerificationTokenType.lostPassword);
    }

    public VerificationToken getActiveEmailVerificationToken() {
        return getActiveToken(VerificationTokenType.emailVerification);
    }

    public VerificationToken getActiveEmailRegistrationToken() {
        return getActiveToken(VerificationTokenType.emailRegistration);
    }

    private VerificationToken getActiveToken(VerificationTokenType tokenType) {
        VerificationToken activeToken = null;
        for (VerificationToken token : getVerificationTokens()) {
            if (token.getTokenType().equals(tokenType)
                    && !token.hasExpired() && !token.isVerified()) {
                activeToken = token;
                break;
            }
        }
        return activeToken;
    }

    //TODO need to add other fields
}
