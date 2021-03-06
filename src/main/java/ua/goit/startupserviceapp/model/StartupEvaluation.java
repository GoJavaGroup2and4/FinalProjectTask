package ua.goit.startupserviceapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "startup_evaluation")
public class StartupEvaluation implements Serializable{
    private UserDB user;
    private Startup startup;
    private int mark;

    public StartupEvaluation() {
    }

    public StartupEvaluation(UserDB user, Startup startup, int mark) {
        this.user = user;
        this.startup = startup;
        this.mark = mark;
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

    @Column(name = "mark")
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "StartupEvaluation{" +
                "user=" + user +
                ", \n startup=" + startup +
                ", \n mark=" + mark +
                '}';
    }
}
