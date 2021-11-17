package com.cte;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        // main takes care of the terminal and runs the application continuous until exit
        String gradebookName = "";
        int sel = 666;
        Scanner userSel = new Scanner(System.in);
        RecordCatalogue recordCatalogue= new RecordCatalogue();
        Filehandler filehandler = new Filehandler();


        while(true)
        {
            System.out.println(" |**********************| ");
            System.out.println(" |****     MENY     ****| ");
            System.out.println(" |**********************| ");
            System.out.println(" 0. List gradebooks ");
            System.out.println(" 1. Add gradebook ");
            System.out.println(" 2. Select a gradebook");
            System.out.println(" 3. Get statistics from the selected gradebook");
            System.out.println(" 4. Get a students grade from the selected gradebook");
            System.out.println(" 5. Add a student to the selected gradebook");
            System.out.println(" 6. Add a grade to an existing student ");

            System.out.println(" 100. Exit ");
            System.out.println("....................");
            System.out.println("Make your choice!");


            //make sure the input is correct
            try {
                sel = userSel.nextInt();
            } catch (Exception e) {
                System.out.println("bad input");
                userSel.next();
            }


            //exit the gradebook app
            if(sel == 100) break;

            //select what action to do
            switch (sel) {
                //list all files in directory
                case 0 -> {
                    System.out.println("Available gradebooks:");
                    filehandler.listFiles();
                }

                //create a new gradebook file
                case 1 -> {
                    System.out.println("Gradebook name");
                    try {
                        gradebookName = userSel.next();
                    } catch (Exception e) {
                        System.out.println("bad input");
                        userSel.next();
                    }
                    filehandler.createFile(gradebookName);
                }

                //read from an existing gradebook
                case 2 -> {
                    System.out.println(" |****************************************| ");
                    System.out.println(" |**** List students from a gradebook ****| ");
                    System.out.println(" |****************************************| ");
                    System.out.println(" 0. Read gradebook");
                    System.out.println(" 1. HOME ");

                    //make sure the input is correct
                    try {
                        sel = userSel.nextInt();
                    } catch (Exception e) {
                        System.out.println("bad input");
                        userSel.next();
                    }

                    switch (sel){
                        case 0 -> {
                            System.out.print("Name of gradebook: ");
                            gradebookName = userSel.next();

                            //read the specified file with the filehandler
                            try {
                                //read the students from the file into the catalogue object
                                recordCatalogue.setStudentList(filehandler.readFile(gradebookName));

                            }
                            catch (Exception e){
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }

                        }
                        default -> System.out.println("go home") ;
                    }

                }

                //read statistics
                case 3 -> {
                    if (recordCatalogue.studentList.size()==0)
                        System.out.println("No gradebook selected");
                    else {
                        System.out.println("Average grade for all students are " + recordCatalogue.getAverageGrade());
                        System.out.println("Highest grade among all students are " + recordCatalogue.getHighestGrade());
                        System.out.println("Lowest grade among all students are " + recordCatalogue.getLowestGrade());
                    }

                }

                //select a student
                case 4 -> {
                    System.out.print("Student name: ");
                    String name = userSel.next();
                    String grade = recordCatalogue.findStudent(name);

                    if (grade.equals("666")) System.out.println("Student not found");
                    else System.out.println(name + "´s grades:" + System.lineSeparator() + grade);
                }

                //add a student
                case 5 -> {

                    System.out.print("Student name: ");
                    String name = userSel.next();
                    System.out.print("Student SSN: ");
                    long SSN = userSel.nextLong();
                    System.out.print("Student Course: ");
                    String course = userSel.next();
                    System.out.print("Student grade: ");
                    int grade = userSel.nextInt();


                    //add both to the object and the file so that you dont need to read the file again or loose if restarting
                    recordCatalogue.addStudent(name,SSN,grade,course);
                    filehandler.writeNewStudentTofile(name,SSN,grade,gradebookName);

                }

                //add a grade to an existing student
                case 6 -> {
                    System.out.print("Student name: ");
                    String name = userSel.next();

                    System.out.print("Course: ");
                    String course = userSel.next();

                    System.out.print("Grade: ");
                    int grade = userSel.nextInt();

                    //add both to the object and the file so that you dont need to read the file again or loose if restarting
                    recordCatalogue.addGradeToStudent(name,grade,course);
                    filehandler.writeStudentsToFile(recordCatalogue,gradebookName);


                }

                default -> System.out.println("0");
            }
        }

    }


}
