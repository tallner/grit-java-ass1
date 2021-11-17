package com.cte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Student class would be the entity to write to a database
public class Student {
    private String name;
    private long SSN;
    private List<Recordbook> recordbook;

    public Student(String name, long SSN) {
        this.name = name;
        this.SSN = SSN;
        this.recordbook = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public long getSSN() {
        return SSN;
    }

    public List<Recordbook> getRecordbook() {
        return recordbook;
    }

    public void addCourse(int grade, String course) {
        this.recordbook.add(new Recordbook(grade,course));
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", SSN=" + SSN +
                ", recordbook=" + recordbook +
                '}';
    }
}
