package ua.lviv.lgs.domain;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private int countOfStudents;

    @Column
    private int minimalPoints;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "university_id",referencedColumnName = "id")
    private Univercity univercity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = {@JoinColumn(name = "faculty_id")}, inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjectSet = new HashSet<Subject>();


    public Faculty(String name, int countOfStudents, int minimalPoints, Set<Subject> subjectSet) {
        this.name = name;
        this.countOfStudents = countOfStudents;
        this.minimalPoints = minimalPoints;
        this.subjectSet = subjectSet;
    }

    public Faculty(Integer id, String name, int countOfStudents, int minimalPoints, Set<Subject> subjectSet) {
        this.id = id;
        this.name = name;
        this.countOfStudents = countOfStudents;
        this.minimalPoints = minimalPoints;
        this.subjectSet = subjectSet;
    }

    public Faculty(String name, int countOfStudents, int minimalPoints) {
        this.name = name;
        this.countOfStudents = countOfStudents;
        this.minimalPoints = minimalPoints;
    }

    public Faculty() {
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

    public int getCountOfStudents() {
        return countOfStudents;
    }

    public void setCountOfStudents(int countOfStudents) {
        this.countOfStudents = countOfStudents;
    }

    public int getMinimalPoints() {
        return minimalPoints;
    }

    public void setMinimalPoints(int minimalPoints) {
        this.minimalPoints = minimalPoints;
    }

    public Set<Subject> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(Set<Subject> subjectSet) {
        this.subjectSet = subjectSet;
    }

    public void setUnivercity(Univercity univercity) {
        this.univercity = univercity;
    }

    public Univercity getUnivercity() {
        return univercity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return countOfStudents == faculty.countOfStudents && minimalPoints == faculty.minimalPoints && Objects.equals(id, faculty.id) && Objects.equals(name, faculty.name) && Objects.equals(subjectSet, faculty.subjectSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countOfStudents, minimalPoints, subjectSet);
    }
}
