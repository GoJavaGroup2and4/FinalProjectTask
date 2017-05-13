package ua.goit.startupserviceapp.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;


@Entity
@Table (name = "projects")
public class Project {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO need to add other fields
}
