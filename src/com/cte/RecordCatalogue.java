package com.cte;

import java.util.*;

public class RecordCatalogue {
    private int HighestGrade=0, LowestGrade=100;
    ArrayList<Student> studentList = new ArrayList<>();

    public float getAverageGrade() {
        int studentsum=0, totalsum=0;
        float studenave=0;
        for (Student student : studentList) {

            for (int i = 0; i < student.getRecordbook().size() ; i++) {
                studentsum += student.getRecordbook().get(i).getGrade();
            }
            studenave = (float)studentsum/student.getRecordbook().size();
            totalsum += studenave;
            studentsum = 0;

        }

        return (float)totalsum/studentList.size();
    }

    public int getHighestGrade() {
        for (int i = 0; i < studentList.size(); i++) {
            for (int j = 0; j < studentList.get(i).getRecordbook().size(); j++) {
                if (studentList.get(i).getRecordbook().get(j).getGrade() > HighestGrade)
                    HighestGrade = studentList.get(i).getRecordbook().get(j).getGrade();
            }
        }
        return HighestGrade;
    }

    public int getLowestGrade() {
        for (int i = 0; i < studentList.size(); i++) {
            for (int j = 0; j < studentList.get(i).getRecordbook().size(); j++) {
                if (studentList.get(i).getRecordbook().get(j).getGrade() < LowestGrade)
                    LowestGrade = studentList.get(i).getRecordbook().get(j).getGrade();
            }
        }

        return LowestGrade;
    }

    public String findStudent(String name) {
        String result = "";

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().equals(name)){

                for (int j = 0; j < studentList.get(i).getRecordbook().size(); j++) {

                    result = result +
                            studentList.get(i).getRecordbook().get(j).getCourse()
                            +": "+
                            studentList.get(i).getRecordbook().get(j).getGrade();
                }
                return result;

//                return studentList.get(i).getRecordbook().getCourse()
//                        +": "+
//                        studentList.get(i).getRecordbook().getGrade();

            }
        }
        return "666";
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(String name, long SSN, int grade, String course){
        Student student = new Student(name,SSN,grade,course);
        studentList.add(student);
    }
//    public void removeStudent(){
//    }
}
