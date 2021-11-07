package com.cte;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // main takes care of the terminal and runs the application continuous until exit
        String gradebookName = "";
        Scanner userSel = new Scanner(System.in);


        int sel = 0;

        while(true)
        {
            System.out.println(" *** MENY *** ");
            System.out.println(" 1. Add gradebook ");
            System.out.println(" 1. Add student ");
            System.out.println(" 2. Edit student ");
            System.out.println(" 3. List students ");
            System.out.println(" 4. Delete student ");
            System.out.println(" 100. Exit ");
            System.out.println("Ange val");

            try {
                sel = userSel.nextInt();
            } catch (Exception e) {
                System.out.println("bad input");
                userSel.next();
            }

            if(sel == 100) break;

            switch (sel) {
                case 1 -> {
                    System.out.println("Gradebook name");
                    try {
                        gradebookName = userSel.next();
                    } catch (Exception e) {
                        System.out.println("bad input");
                        userSel.next();
                    }
                    Filehandler filehandler = new Filehandler(gradebookName);
                    filehandler.createFile();
                }
                case 2 -> {
                    Filehandler filehandler1 = new Filehandler(gradebookName);
                    filehandler1.listFiles();
                }
                case 3 -> System.out.println("3");
                case 4 -> System.out.println("4");
                case 5 -> System.out.println("5");
                default -> System.out.println("0");
            }


        }


    }




}
