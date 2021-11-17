package com.cte;

import java.util.*;

public class RecordCatalogue {
    private int HighestGrade=0, LowestGrade=100;
    ArrayList<Student> studentList = new ArrayList<>();

    public RecordCatalogue() {
    }

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

    //Find a student and get the grades
    public String findStudent(String name) {
        String result = "";

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().equals(name)){

                for (int j = 0; j < studentList.get(i).getRecordbook().size(); j++) {

                    result = result +
                            studentList.get(i).getRecordbook().get(j).getCourse()
                            +": "+
                            studentList.get(i).getRecordbook().get(j).getGrade()
                            +" | ";
                }
                return result;
            }
        }
        return "666";
    }

    //Find a student and get the grades
    //ONLY TAKES NAME INTO ACCOUNT, so if you have students with the same name youre screwed
    public String addGradeToStudent(String name,int grade, String course) {
        String result = "";

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().equals(name)){
                studentList.get(i).addCourse(grade,course);
                return course+":"+grade+"added to"+name;
            }
        }
        return "Student not found";
    }

    //sets the list of all students and their grades
    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    //returns all students and their grades
    public ArrayList<Student> getStudentList(){
        return this.studentList;
    }

    //adds a student to the catalogue
    public void addStudent(String name, long SSN, int grade, String course){
        //add a new student
        Student student = new Student(name,SSN);
        //add grade to this student
        student.addCourse(grade,course);
        //add to student to the list
        studentList.add(student);


    }

//    public void removeStudent(){
//    }
}
