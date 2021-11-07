package com.cte;

//Student class would be the entity to write to a database
public class Student {
    private int id;
    private String name;
    private double SSN;
    private String course;
    private String grade;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSSN() {
        return SSN;
    }

    public void setSSN(double SSN) {
        this.SSN = SSN;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
