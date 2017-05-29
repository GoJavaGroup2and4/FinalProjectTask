package ua.goit.startupserviceapp.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    private long id;
    private String name;
    private List<Permission> permissions = new ArrayList<>();

    private List<UserDB> users = new ArrayList<>();


    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return name != null ? name.equals(role.name) : role.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Id
    @Column(name = "role_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "role_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }


    @ManyToMany
    public List<UserDB> getUsers() {
        return users;
    }

    public void setUsers(List<UserDB> users) {
        this.users = users;
    }
}
