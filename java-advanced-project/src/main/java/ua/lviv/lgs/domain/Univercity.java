package ua.lviv.lgs.domain;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

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

}
