package ua.lviv.lgs.domain;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.MERGE;

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

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.PERSIST, MERGE}, mappedBy = "userId")
    private List<Subject> subjects;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.ALL, MERGE}, mappedBy = "user")
    private Set<Univercity> univercities;

    @Lob
    private byte[] file;

    @Lob
    private String encodedImage;


    public User(Integer id, String firstName, String lastName, int enabled, Role role, String password, String email, String encodedImage) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.role = role;
        this.password = password;
        this.email = email;
        this.encodedImage = encodedImage;
    }

    public User(String firstName, String lastName, int enabled, Role role, String password, String email) {
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
        this.encodedImage = user.encodedImage;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
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

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public byte[] getFile() {
        return file;
    }

    public String getEncodedImage() {
        return encodedImage;
    }

    public void setEncodedImage(String encodedImage) {
        this.encodedImage = encodedImage;
    }

    public void setFile(byte[] file) {
        this.file = file;
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
