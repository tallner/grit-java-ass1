package com.cte;

//import java.io.File;  // Import the File class
//import java.io.IOException;  // Import the IOException class to handle errors
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {
    private File myObj;
    private final String basePath = "./_gradebooks/";

    public Filehandler() {
    }

    public void listFiles(){
        try {

            // create new file
            myObj = new File(basePath);

            // array of files and directory
            String[] paths = myObj.list();

            // for each name in the path array
            for(String path: paths) {

                // prints filename and directory name
                System.out.println(path);
            }

        } catch(Exception e) {
            // if any error occurs
            e.printStackTrace();
        }
    }

    public void createFile(String filename) {
        try {
            myObj = new File(basePath+filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeNewStudentTofile(String name, long SSN, int grade, String filename){
        try {
            FileWriter myWriter = new FileWriter(basePath+filename,true);
            myWriter.write(System.lineSeparator());
            myWriter.write(name + System.lineSeparator());
            myWriter.write(SSN + System.lineSeparator());
            myWriter.write( Integer.toString(grade) );

            myWriter.close();
            System.out.println("Successfully added to the gradebook.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeStudentsToFile(RecordCatalogue recordCatalogue, String filename){
        try {
            FileWriter myWriter = new FileWriter(basePath+filename,false);
            ArrayList<Student> students = recordCatalogue.getStudentList();
            //students = recordCatalogue.getStudentList();

            for (int i = 0; i < students.size() ; i++) {
                myWriter.write(students.get(i).getName() + System.lineSeparator());
                myWriter.write(students.get(i).getSSN() + System.lineSeparator());

                for (int j = 0; j < students.get(i).getRecordbook().size(); j++) {
                    myWriter.write(students.get(i).getRecordbook().get(j).getCourse() + System.lineSeparator());
                    myWriter.write(students.get(i).getRecordbook().get(j).getGrade() + System.lineSeparator());

                    if ((students.get(i).getRecordbook().size() > 1) && (j<(students.get(i).getRecordbook().size())-1)) {
                        myWriter.write("newcourse" + System.lineSeparator());
                    }
                }
                myWriter.write("/" + System.lineSeparator());

            }

            myWriter.close();
            System.out.println("Successfully printed the gradebook.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<Student> readFile(String filename) {
        try {
            myObj = new File(basePath+filename);
            Scanner myReader = new Scanner(myObj);
            ArrayList<Student> studentList = new ArrayList<>();

            System.out.println("Students");

            while (myReader.hasNextLine()) {

                String name = myReader.next(); //read name from the file
                long SSN = myReader.nextLong(); //read SSN from the file
                Student student = new Student(name,SSN);//create a new student that can be added to the arralist of students

                do {//iterate through the grades of the student
                    String course = myReader.next();//read course from the file
                    int grade = myReader.nextInt();//read grade from the file

                    student.addCourse(grade,course); //add the grades and courses
                    myReader.nextLine().contains("newcourse");//just to get to right line in the scanner

                }while (!myReader.nextLine().contains("/"));

                studentList.add(student); //add the student to the arraylist of students
                System.out.println(student.getName());

            }
            myReader.close();
//            System.out.println(studentList);
            return studentList;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }

    }



}
