package ua.goit.startupserviceapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_startup")
public class UserStartup implements Serializable{
    private UserDB user;
    private Startup startup;
    private int userInvestment;

    public UserStartup(int user_id, int startup_id, int investment) {
    }

    public UserStartup() {
        this.user = user;
        this.startup = startup;
        this.userInvestment = userInvestment;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public UserDB getUser() {
        return user;
    }

    public void setUser(UserDB user) {
        this.user = user;
    }

    @Id
    @ManyToOne
    @JoinColumn (name = "startup_id", nullable = false)
    public Startup getStartup() {
        return startup;
    }

    public void setStartup(Startup startup) {
        this.startup = startup;
    }

    @Column(name = "user_investment")
    public int getUserInvestment() {
        return userInvestment;
    }

    public void setUserInvestment(int userInvestment) {
        this.userInvestment = userInvestment;
    }

    @Override
    public String toString() {
        return "UserStartup{" +
                "user=" + user +
                ", \n startup=" + startup +
                '}';
    }
}
