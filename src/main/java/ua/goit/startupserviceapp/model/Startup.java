package ua.goit.startupserviceapp.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table (name = "startup")
public class Startup {
    private long id;
    private String name;
    private byte[] image;
    private byte[] attachment;
    private int current_investment;
    private int needed_investment;
    private String description;
    private double rating;
    private String status;
    private Category category;
    private Set<StartupEvaluation> marks = new HashSet<>();
    private Set<UserStartup> users = new HashSet<>();

    @Id
    @Column(name = "startup_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "startup_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Lob
    @Column(name="picture")
    @Type(type="org.hibernate.type.BinaryType")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Lob
    @Column(name="attachment")
    @Type(type="org.hibernate.type.BinaryType")
    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    @Column(name = "current_investment")
    public int getCurrent_investment() {
        return current_investment;
    }

    public void setCurrent_investment(int current_investment) {
        this.current_investment = current_investment;
    }

    @Column(name = "needed_investment", nullable = false)
    public int getNeeded_investment() {
        return needed_investment;
    }

    public void setNeeded_investment(int needed_investment) {
        this.needed_investment = needed_investment;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "rating")
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn (name = "category", nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "startup")
    public Set<StartupEvaluation> getMarks() {
        return marks;
    }

    public void setMarks(Set<StartupEvaluation> marks) {
        this.marks = marks;
    }

    @OneToMany(mappedBy = "startup")
    public Set<UserStartup> getUsers() {
        return users;
    }

    public void setUsers(Set<UserStartup> users) {
        this.users = users;
    }

    public Startup() {
    }

    public Startup(String name, int needed_investment, Category category) {
        this.name = name;
        this.needed_investment = needed_investment;
        this.category = category;
    }

    public Startup(long id, String name, byte[] image, byte[] attachment, int current_investment, int needed_investment, String description, double rating, String status, Category category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.attachment = attachment;
        this.current_investment = current_investment;
        this.needed_investment = needed_investment;
        this.description = description;
        this.rating = rating;
        this.status = status;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Startup startup = (Startup) o;

        if (needed_investment != startup.needed_investment) return false;
        if (name != null ? !name.equals(startup.name) : startup.name != null) return false;
        return category != null ? category.equals(startup.category) : startup.category == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + needed_investment;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Startup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                ", attachment=" + Arrays.toString(attachment) +
                ", current_investment=" + current_investment +
                ", needed_investment=" + needed_investment +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", status='" + status + '\'' +
                ", category=" + category +
                '}';
    }
}