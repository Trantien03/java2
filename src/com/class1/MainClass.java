package com.class1;

import java.io.File;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        FileManagement file = new FileManagement();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter word to find: ");
        String word = input.nextLine();

        File directory
                = new File("D:\\java\\class1");

        try {
            file.getFile(directory, word);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

//        File fileSource = new File("E:\\newfile.txt");
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter word to find: ");
//        String word = input.nextLine();
//
//        //"E:\\FAPTECH\\SEM2\\JAVA2\\Class1"
//
//        try {
//            //String str = file.readFile(fileSource);
//            int count = file.countWord(fileSource, word);
//            if(count > 0) {
//                System.out.println(word + " found " + count + " times");
//            } else  {
//                System.out.println("Word not found");
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

    }
}

