package ua.goit.startupserviceapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_startup")
public class UserStartup implements Serializable{
    private UserDB user;
    private Startup project;
    private Date startDate;
    private Date endDate;

    public UserStartup() {
    }

    public UserStartup(UserDB user, Startup project) {
        this.user = user;
        this.project = project;
    }

    public UserStartup(UserDB user, Startup project, Date startDate, Date endDate) {
        this.user = user;
        this.project = project;
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
    public Startup getProject() {
        return project;
    }

    public void setProject(Startup project) {
        this.project = project;
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
                ", project=" + project +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
