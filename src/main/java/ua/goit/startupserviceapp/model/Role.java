package ua.goit.startupserviceapp.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table (name = "roles")
public class Role {

    @Id
    @Column(name = "id_role",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_role;

    @Column(name = "name")
    private String name;

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

        if (id_role != null ? !id_role.equals(role.id_role) : role.id_role != null) return false;
        return name != null ? name.equals(role.name) : role.name == null;
    }

    @Override
    public int hashCode() {
        int result = id_role != null ? id_role.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId_role() {
        return id_role;
    }

    public void setId_role(Long id_role) {
        this.id_role = id_role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
