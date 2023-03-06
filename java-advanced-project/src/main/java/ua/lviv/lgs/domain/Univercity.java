package ua.lviv.lgs.domain;

import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table
public class Univercity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private Long countOfStudents;

    @Column
    private String description;

    @Column
    private Double rating;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;


    @OneToMany(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE}, mappedBy="univercity")
    private Set<Faculty> faculties;


    public Univercity() {
    }

    public Univercity(String name, Long countOfStudents) {
        this.name = name;
        this.countOfStudents = countOfStudents;
    }

    public Univercity(Integer id, String name, Long countOfStudents) {
        this.id = id;
        this.name = name;
        this.countOfStudents = countOfStudents;
    }

    public Univercity(String name,String description, Set<Faculty> faculties) {
        this.name = name;
        this.description = description;
        this.faculties = faculties;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountOfStudents() {
        return countOfStudents;
    }

    public void setCountOfStudents(Long countOfStudents) {
        this.countOfStudents = countOfStudents;
    }

    public Double getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Univercity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countOfStudents=" + countOfStudents +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", user=" + user +
                ", faculties=" + faculties +
                '}';
    }
}
