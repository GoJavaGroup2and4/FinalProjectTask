package ua.goit.startupserviceapp.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserDB {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String country;
    private String city;
    private String login;
    private String password;
    private int active;
    private Set<StartupEvaluation> marks = new HashSet<>();
    private Set<UserStartup> startups = new HashSet<>();

    private List<Role> roles=new ArrayList<>();
  //  private List<VerificationToken> verificationTokens = new ArrayList<VerificationToken>();
   // private AuthorizationToken authorizationToken;

//    @Transient
//    private boolean isVerified;


    private String confirmPassword;



    public UserDB() {
    }

    public UserDB(String firstName, String lastName, String email, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "login", nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "is_active")
    public int isActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @OneToMany(mappedBy = "user")
    public Set<StartupEvaluation> getMarks() {
        return marks;
    }

    public void setMarks(Set<StartupEvaluation> marks) {
        this.marks = marks;
    }

    @OneToMany(mappedBy = "user")
    public Set<UserStartup> getStartups() {
        return startups;
    }

    public void setStartups(Set<UserStartup> startups) {
        this.startups = startups;
    }

    @Transient
    public String getConfirmPassword() {
        return confirmPassword;
    }

    @Transient
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    /* @OneToMany(mappedBy="user",
            targetEntity=VerificationToken.class,
            cascade= CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<VerificationToken> getVerificationTokens() {
        return verificationTokens;
    }

    public void setVerificationTokens(List<VerificationToken> verificationTokens) {
        this.verificationTokens = verificationTokens;
    }*/

//    @Transient
//    public boolean isVerified() {
//        return isVerified;
//    }
//
//    public void setVerified(boolean verified) {
//        this.isVerified = verified;
//    }
 /*
    public synchronized void addVerificationToken(VerificationToken token) {
        this.verificationTokens.add(token);
    }

   @OneToOne(fetch = FetchType.LAZY,
            mappedBy = "user",
            cascade = CascadeType.ALL)
    public synchronized AuthorizationToken getAuthorizationToken() {
        return authorizationToken;
    }

    public synchronized void setAuthorizationToken(AuthorizationToken token) {
        this.authorizationToken = token;
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
    }*/

    @Override
    public String toString() {
        return "UserDB{" +
                "id=" + id +
                ", \n firstName='" + firstName + '\'' +
                ", \n lastName='" + lastName + '\'' +
                ", \n phoneNumber='" + phoneNumber + '\'' +
                ", \n email='" + email + '\'' +
                ", \n country='" + country + '\'' +
                ", \n city='" + city + '\'' +
                ", \n login='" + login + '\'' +
                ", \n password='" + password + '\'' +
                ", \n active=" + active +
                '}';
    }
}
