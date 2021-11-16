package com.cte;

public class Recordbook {
    private int grade;
    private String course;

    public Recordbook(int grade, String course) {
        this.grade = grade;
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }
    public String getCourse() {
        return course;
    }
//
//    public void setGrade(int grade) {
//        this.grade = grade;
//    }


    @Override
    public String toString() {
        return "Recordbook{" +
                "grade=" + grade +
                ", course='" + course + '\'' +
                '}';
    }
}
