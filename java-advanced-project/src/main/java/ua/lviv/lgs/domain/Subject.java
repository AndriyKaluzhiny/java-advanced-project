package ua.lviv.lgs.domain;

public class Subject {
    private Integer id;
    private String name;
    private int points;

    public Subject() {
    }

    public Subject(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public Subject(Integer id, String name, int points) {
        this.id = id;
        this.name = name;
        this.points = points;
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
}
