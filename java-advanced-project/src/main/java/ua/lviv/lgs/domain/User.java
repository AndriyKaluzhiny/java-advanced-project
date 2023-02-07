package ua.lviv.lgs.domain;

import javax.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int enabled;

    @Column
    private String role;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.ALL, CascadeType.MERGE}, mappedBy = "user")
    private Set<Univercity> univercities;


    public User(Integer id, String firstName, String lastName, int enabled, String role, String password, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.role = role;
        this.password = password;
        this.email = email;
    }

    public User(String firstName, String lastName, int enabled, String role, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.role = role;
        this.password = password;
        this.email = email;
    }

    public User(User user) {
        this.id = user.id;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.role = user.role;
        this.email = user.email;
        this.password = user.password;
        this.univercities = user.univercities;
        this.enabled = user.enabled;
    }

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Univercity> getUnivercities() {
        return univercities;
    }

    public void setUnivercities(Set<Univercity> univercities) {
        this.univercities = univercities;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", enabled=" + enabled +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", univercities=" + univercities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enabled == user.enabled && Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(role, user.role) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(univercities, user.univercities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, enabled, role, email, password, univercities);
    }


}
