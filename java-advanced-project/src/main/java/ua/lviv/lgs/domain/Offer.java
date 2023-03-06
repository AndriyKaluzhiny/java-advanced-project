package ua.lviv.lgs.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String universityName;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private Integer summary;

    @Column
    boolean applyDeny;


    public Offer() {
    }

    public Integer getId() {
        return id;
    }

    public void setApplyDeny(boolean applyDeny) {
        this.applyDeny = applyDeny;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public Integer getSummary() {
        return summary;
    }

    public void setSummary(Integer summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", universityName='" + universityName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", summary=" + summary +
                ", applyDeny=" + applyDeny +
                '}';
    }
}
