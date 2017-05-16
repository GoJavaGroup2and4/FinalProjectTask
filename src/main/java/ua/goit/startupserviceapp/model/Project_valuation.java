package ua.goit.startupserviceapp.model;

import javax.persistence.*;

/**
 * Created by Alexander on 16/05/2017.
 */
@Entity
@Table(name = "project_valuation")
public class Project_valuation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_user")
    private int id_user;

    @Column(name = "id_project")
    private int id_project;

    @Column(name = "mark")
    private int mark;

    public Project_valuation() {
    }

    public Project_valuation(int id, int id_user, int id_project, int mark) {
        this.id = id;
        this.id_user = id_user;
        this.id_project = id_project;
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project_valuation that = (Project_valuation) o;

        if (id != that.id) return false;
        if (id_user != that.id_user) return false;
        if (id_project != that.id_project) return false;
        return mark == that.mark;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + id_user;
        result = 31 * result + id_project;
        result = 31 * result + mark;
        return result;
    }

    @Override
    public String toString() {
        return "Project_valuation{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", id_project=" + id_project +
                ", mark=" + mark +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

//    TODO set relations
}
