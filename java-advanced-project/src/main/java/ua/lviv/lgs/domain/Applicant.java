package ua.lviv.lgs.domain;

import java.util.Set;


public class Applicant {

    private Integer id;
    private String firstName;
    private String lastName;
    private Set<Subject> subjectsSet;
    private int enabled;
    private String role;


    public Applicant(Integer id, String firstName, String lastName, Set<Subject> subjectsSet, int enabled, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjectsSet = subjectsSet;
        this.enabled = enabled;
        this.role = role;
    }

    public Applicant(String firstName, String lastName, Set<Subject> subjectsSet, int enabled, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjectsSet = subjectsSet;
        this.enabled = enabled;
        this.role = role;
    }

    public Applicant() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Subject> getSubjectsSet() {
        return subjectsSet;
    }

    public void setSubjectsSet(Set<Subject> subjectsSet) {
        this.subjectsSet = subjectsSet;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
