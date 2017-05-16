package ua.goit.startupserviceapp.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table (name = "roles")
public class Role {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //TODO need to add other fields

}
