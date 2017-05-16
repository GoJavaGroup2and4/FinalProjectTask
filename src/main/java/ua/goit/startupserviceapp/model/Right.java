package ua.goit.startupserviceapp.model;

import javax.persistence.*;

/**
 * Created by Alexander on 16/05/2017.
 */
@Entity
@Table(name = "right")
public class Right {

    @Id
    @Column(name = "id_right")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_right;

    @Column(name = "right_name")
    private String right_name;

    public Right() {
    }

    public Right(int id_right, String right_name) {
        this.id_right = id_right;
        this.right_name = right_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Right right = (Right) o;

        return right_name != null ? right_name.equals(right.right_name) : right.right_name == null;
    }

    @Override
    public int hashCode() {
        return right_name != null ? right_name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Right{" +
                "id_right=" + id_right +
                ", right_name='" + right_name + '\'' +
                '}';
    }

    public int getId_right() {
        return id_right;
    }

    public void setId_right(int id_right) {
        this.id_right = id_right;
    }

    public String getRight_name() {
        return right_name;
    }

    public void setRight_name(String right_name) {
        this.right_name = right_name;
    }
}
