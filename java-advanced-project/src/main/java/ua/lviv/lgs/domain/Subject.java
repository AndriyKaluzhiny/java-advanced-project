package ua.lviv.lgs.domain;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private int points;

    @ManyToMany(mappedBy = "subjectSet")
    private Set<Faculty> faculties = new HashSet<Faculty>();

    public Subject() {
    }

    public Subject(String name, int points, Set<Faculty> faculties) {
        this.name = name;
        this.points = points;
        this.faculties = faculties;
    }

    public Subject(Integer id, String name, int points, Set<Faculty> faculties) {
        this.id = id;
        this.name = name;
        this.points = points;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return points == subject.points && Objects.equals(id, subject.id) && Objects.equals(name, subject.name) && Objects.equals(faculties, subject.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, points, faculties);
    }
}
