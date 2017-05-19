package ua.goit.startupserviceapp.model;

//TODO delete because of Startup was created
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.Arrays;

/*
@Entity
@Table (name = "projects")
public class Project {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_name")
    private String project_name;

    @Column(name = "picture")
    @Lob
    private byte[] picture;

    @Column(name = "attachment")
    @Lob
    private byte[] attachment;

    @Column(name = "current_investment")
    private int current_investment;

    @Column(name = "nesessary_investment")
    private int nesessary_investment;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private double rating;

    @Column(name = "category")
    private String category;

    @Column(name = "author")
    private String author;

    @Column(name = "valuation")
    private int valuation;

    @Column(name = "status")
    private String status;

    public Project() {
    }

    public Project(String project_name, byte[] picture, byte[] attachment, int current_investment, int nesessary_investment, String description, double rating, String category, String author, int valuation, String status) {
        this.project_name = project_name;
        this.picture = picture;
        this.attachment = attachment;
        this.current_investment = current_investment;
        this.nesessary_investment = nesessary_investment;
        this.description = description;
        this.rating = rating;
        this.category = category;
        this.author = author;
        this.valuation = valuation;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (current_investment != project.current_investment) return false;
        if (nesessary_investment != project.nesessary_investment) return false;
        if (Double.compare(project.rating, rating) != 0) return false;
        if (valuation != project.valuation) return false;
        if (project_name != null ? !project_name.equals(project.project_name) : project.project_name != null)
            return false;
        if (!Arrays.equals(picture, project.picture)) return false;
        if (!Arrays.equals(attachment, project.attachment)) return false;
        if (description != null ? !description.equals(project.description) : project.description != null) return false;
        if (category != null ? !category.equals(project.category) : project.category != null) return false;
        if (author != null ? !author.equals(project.author) : project.author != null) return false;
        return status != null ? status.equals(project.status) : project.status == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = project_name != null ? project_name.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(picture);
        result = 31 * result + Arrays.hashCode(attachment);
        result = 31 * result + current_investment;
        result = 31 * result + nesessary_investment;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + valuation;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", project_name='" + project_name + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", attachment=" + Arrays.toString(attachment) +
                ", current_investment=" + current_investment +
                ", nesessary_investment=" + nesessary_investment +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", valuation=" + valuation +
                ", status='" + status + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    public int getCurrent_investment() {
        return current_investment;
    }

    public void setCurrent_investment(int current_investment) {
        this.current_investment = current_investment;
    }

    public int getNesessary_investment() {
        return nesessary_investment;
    }

    public void setNesessary_investment(int nesessary_investment) {
        this.nesessary_investment = nesessary_investment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getValuation() {
        return valuation;
    }

    public void setValuation(int valuation) {
        this.valuation = valuation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //TODO to add OneToMany relation
}*/
