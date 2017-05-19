package ua.goit.startupserviceapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_startup")
public class UserStartup implements Serializable{
    private UserDB user;
    private Startup startup;
    private Date startDate;
    private Date endDate;

    public UserStartup() {
    }

    public UserStartup(UserDB user, Startup startup) {
        this.user = user;
        this.startup = startup;
    }

    public UserStartup(UserDB user, Startup startup, Date startDate, Date endDate) {
        this.user = user;
        this.startup = startup;
        this.startDate = startDate;
        this.endDate = endDate;
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

    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "UserStartup{" +
                "user=" + user +
                ", \n startup=" + startup +
                ", \n startDate=" + startDate +
                ", \n endDate=" + endDate +
                '}';
    }
}
