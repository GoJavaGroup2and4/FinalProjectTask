package ua.goit.startupserviceapp.model;

import javax.persistence.*;

@Entity
@Table(name = "permission")
public class Permission {
    private long id;
    private String name;

    public Permission() {
    }

    public Permission(String name) {
        this.name = name;
    }

    public Permission(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "permission_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "permission_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
