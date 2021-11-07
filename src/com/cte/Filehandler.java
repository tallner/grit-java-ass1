package com.cte;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class Filehandler {
    File myObj;
    String[] paths;

    public Filehandler(String filename) {
        this.myObj = new File(filename);
    }

    public void listFiles(){
        try {

            // create new file
            myObj = new File("C:/ProgrammingCourses/grit/javaprogrammering/grit-java-ass1/_gradebooks");

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


    //
//
//        if (myObj.createNewFile()) {
//            System.out.println("File created: " + myObj.getName());
//        } else {
//            System.out.println("File already exists.");
//        }
//



}
