package ua.goit.startupserviceapp.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table (name = "category")
public class Category {
    private long id;
    private String name;
    private Set<Startup> startups = new HashSet<>();

    @Id
    @Column(name = "category_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "category_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "category")
    public Set<Startup> getStartups() {
        return startups;
    }

    public void setStartups(Set<Startup> startups) {
        this.startups = startups;
    }

    public Category(long id, String name, Set<Startup> startups) {
        this.id = id;
        this.name = name;
        this.startups = startups;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", \n name='" + name + '\'' +
                '}';
    }
}
