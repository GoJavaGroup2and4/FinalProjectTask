package ua.goit.startupserviceapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "project_evaluation")
public class ProjectEvaluation implements Serializable{
    private UserDB user;
    private Startup project;
    private int mark;

    public ProjectEvaluation() {
    }

    public ProjectEvaluation(UserDB user, Startup project, int mark) {
        this.user = user;
        this.project = project;
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
    @JoinColumn (name = "project_id", nullable = false)
    public Startup getProject() {
        return project;
    }

    public void setProject(Startup project) {
        this.project = project;
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
        return "ProjectEvaluation{" +
                "user=" + user +
                ", project=" + project +
                ", mark=" + mark +
                '}';
    }
}
