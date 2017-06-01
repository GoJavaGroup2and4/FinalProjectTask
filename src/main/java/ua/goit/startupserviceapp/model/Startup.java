package ua.goit.startupserviceapp.model;

import javax.persistence.*;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table (name = "startup")
public class Startup {
    private long id;
    private String name;
    private Blob image;
    private Blob attachment;
    private int current_investment;
    private int needed_investment;
    private String description;
    private Double rating;
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
    @Column(name="picture", columnDefinition="BLOB")
    //  @Type(type="org.hibernate.type.BinaryType")
    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    @Lob
    @Column(name="attachment", columnDefinition="BLOB")
    // @Type(type="org.hibernate.type.BinaryType")
    public Blob getAttachment() {
        return attachment;
    }

    public void setAttachment(Blob attachment) {
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
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Column(name = "status")
//    @Enumerated(EnumType.STRING) // Add lately or never add
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "startup")
    public Set<StartupEvaluation> getMarks() {
        return marks;
    }

    public void setMarks(Set<StartupEvaluation> marks) {
        this.marks = marks;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "startup")
    public Set<UserStartup> getUsers() {
        return users;
    }

    public void setUsers(Set<UserStartup> users) {
        this.users = users;
    }

    public Startup() {
    }

    public Startup(String name, String description, int needed_investment, Category category) {
        this.name = name;
        this.description = description;
        this.needed_investment = needed_investment;
        this.category = category;
    }

    //    TODO: Do we need String status in parameters? Isn't default status for newly created Startup "Draft"?
    public Startup(long id, String name, Blob image, Blob attachment, int current_investment, int needed_investment, String description, Double rating, Category category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.attachment = attachment;
        this.current_investment = current_investment;
        this.needed_investment = needed_investment;
        this.description = description;
        this.rating = rating;
        this.status = "Draft";
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
                ", \n name='" + name + '\'' +
                ", \n current_investment=" + current_investment +
                ", \n needed_investment=" + needed_investment +
                ", \n description='" + description + '\'' +
                ", \n rating=" + rating +
                ", \n status='" + status + '\'' +
                ", category=" + category +
                '}';
    }
}