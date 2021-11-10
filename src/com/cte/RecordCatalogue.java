package com.cte;

import java.util.*;

public class RecordCatalogue {
    private int HighestGrade=0, LowestGrade=100;
    ArrayList<Student> studentList = new ArrayList<Student>();

    public float getAverageGrade() {
        int sumGrade=0;
        for (Student student : studentList) {
            sumGrade += student.getRecordbook().getGrade();
        }

        return (float)sumGrade/studentList.size();
    }

    public int getHighestGrade() {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getRecordbook().getGrade() > HighestGrade)
                HighestGrade = studentList.get(i).getRecordbook().getGrade();
        }
        return HighestGrade;
    }

    public int getLowestGrade() {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getRecordbook().getGrade() < LowestGrade)
                LowestGrade = studentList.get(i).getRecordbook().getGrade();
        }
        return LowestGrade;
    }

    public int findStudent(String name) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().equals(name))
                return studentList.get(i).getRecordbook().getGrade();
        }
        return 666;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(String name, long SSN, int grade){
        Student student = new Student(name,SSN,grade);
        studentList.add(student);
    }
//    public void removeStudent(){
//    }
}
