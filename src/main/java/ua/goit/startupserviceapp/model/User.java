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
public class User {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "role")
    private int role;

    @Column(name = "phone_number")
    private int phone_number;

    @Column(name = "email")
    private String email;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "is_active")
    private byte is_active;

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


    public User() {
    }

    public User(String first_name, String last_name, int role, int phone_number, String email, String country, String city, String login, String password, byte is_active) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
        this.phone_number = phone_number;
        this.email = email;
        this.country = country;
        this.city = city;
        this.login = login;
        this.password = password;
        this.is_active = is_active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (role != user.role) return false;
        if (phone_number != user.phone_number) return false;
        if (is_active != user.is_active) return false;
        if (first_name != null ? !first_name.equals(user.first_name) : user.first_name != null) return false;
        if (last_name != null ? !last_name.equals(user.last_name) : user.last_name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (country != null ? !country.equals(user.country) : user.country != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = first_name != null ? first_name.hashCode() : 0;
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + role;
        result = 31 * result + phone_number;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) is_active;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", role=" + role +
                ", phone_number=" + phone_number +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", is_active=" + is_active +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getIs_active() {
        return is_active;
    }

    public void setIs_active(byte is_active) {
        this.is_active = is_active;
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
}
