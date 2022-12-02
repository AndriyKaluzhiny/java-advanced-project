package ua.lviv.lgs.domain;

public class Faculty {
    private Integer id;
    private String name;
    private int countOfStudents;
    private int minimalPoints;


    public Faculty(String name, int countOfStudents, int minimalPoints) {
        this.name = name;
        this.countOfStudents = countOfStudents;
        this.minimalPoints = minimalPoints;
    }

    public Faculty(Integer id, String name, int countOfStudents, int minimalPoints) {
        this.id = id;
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
}
