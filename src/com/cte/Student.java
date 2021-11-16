package com.cte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Student class would be the entity to write to a database
public class Student {
    private String name;
    private long SSN;

    private List<Recordbook> recordbook;

    //private Recordbook recordbook;
    //ArrayList<Recordbook> recordbook = new ArrayList<>();


 //   public Student() {
 //       this.name = "";
 //       this.SSN = 0;
 //       this.recordbook = new Recordbook(0);
 //   }
    public Student(String name, long SSN, int grade, String course) {
        this.name = name;
        this.SSN = SSN;

        //how to init the first member in the list in a better way???
        this.recordbook = new ArrayList<>();
        Recordbook initbook = new Recordbook(grade, course);
        recordbook.add(initbook);
    }
    public Student(String name, long SSN) {
        this.name = name;
        this.SSN = SSN;
        this.recordbook = new ArrayList<>();
    }
    public Student() {
        this.recordbook = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//    public long getSSN() {
//        return SSN;
//    }
//
//    public void setSSN(long SSN) {
//        this.SSN = SSN;
//    }

    public List<Recordbook> getRecordbook() {
        return recordbook;
    }

//    public Recordbook getRecordbook() {
//        return recordbook;
//    }

    public void addStudent(String name, long SSN){
        this.name = name;
        this.SSN = SSN;
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
