package ua.lviv.lgs.domain;

import java.util.Set;

public class Univercity {
    private Integer id;
    private String name;
    private Long countOfStudents;
    private Set<Faculty> faculties;

    public Univercity() {
    }

    public Univercity(String name, Long countOfStudents, Set<Faculty> faculties) {
        this.name = name;
        this.countOfStudents = countOfStudents;
        this.faculties = faculties;
    }

    public Univercity(Integer id, String name, Long countOfStudents, Set<Faculty> faculties) {
        this.id = id;
        this.name = name;
        this.countOfStudents = countOfStudents;
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

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }
}
