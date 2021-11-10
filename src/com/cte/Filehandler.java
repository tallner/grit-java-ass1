package com.cte;

//import java.io.File;  // Import the File class
//import java.io.IOException;  // Import the IOException class to handle errors
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {
    File myObj;
    String[] paths;
    String basePath = "C:/ProgrammingCourses/grit/javaprogrammering/grit-java-ass1/_gradebooks/";


    public Filehandler(String filename) {
        myObj = new File(filename);
    }

    public void listFiles(){
        try {

            // create new file
            myObj = new File(basePath);

            // array of files and directory
            paths = myObj.list();

            // for each name in the path array
            for(String path:paths) {

                // prints filename and directory name
                System.out.println(path);
            }

        } catch(Exception e) {
            // if any error occurs
            e.printStackTrace();
        }
    }

    public void createFile() {
        try {
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

    public void writefile(String name, long SSN, int grade, String filename){
        try {
            FileWriter myWriter = new FileWriter(basePath+filename,true);
            myWriter.write(System.lineSeparator());
            myWriter.write(name + System.lineSeparator());
            myWriter.write(SSN + System.lineSeparator());
            myWriter.write( Integer.toString(grade) );

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<Student> readFile(String filename) {
        try {
            myObj = new File(basePath+filename);
            Scanner myReader = new Scanner(myObj);
            ArrayList<Student> studentList = new ArrayList<Student>();

            System.out.println("Students");
            while (myReader.hasNextLine()) {

                String name = myReader.next();
                long SSN = myReader.nextLong();
                int grade = myReader.nextInt();

                studentList.add(new Student(name,SSN,grade));
                System.out.println(name);

            }
            myReader.close();
            return studentList;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }

    }


    //
//
//        if (myObj.createNewFile()) {
//            System.out.println("File created: " + myObj.getName());
//        } else {
//            System.out.println("File already exists.");
//        }
//



}
