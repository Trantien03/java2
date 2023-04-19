package com.class2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        String path = "";
        String word = "";

        while (option != 3) {
            System.out.println("============ Word Program =========");
            System.out.println("1. Count Word In File");
            System.out.println("2. Find File By Word");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("-------- Count Word --------");
                    System.out.print("Enter Path: ");
                    path = scanner.next();
                    System.out.print("Enter Word: ");
                    word = scanner.next();
                    try {
                        int count = countWordInFile(path, word);
                        System.out.println("Bout: " + count);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.println("-------- Find File By Word --------");
                    System.out.print("Enter Path: ");
                    path = scanner.next();
                    System.out.print("Enter Word: ");
                    word = scanner.next();
                    try {
                        List<String> files = getFileNameContainsWordInDirectory(path, word);
                        System.out.println("------------ File Name ------------");
                        for (String file : files) {
                            System.out.println(file);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    public static int countWordInFile(String fileSource, String word) throws Exception {
        File file = new File(fileSource);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int count = 0;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String w : words) {
                if (w.equalsIgnoreCase(word)) {
                    count++;
                }
            }
        }
        br.close();
        return count;
    }

    public static List<String> getFileNameContainsWordInDirectory(String source, String word) throws Exception {
        List<String> files = new ArrayList<>();
        File folder = new File(source);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                boolean found = false;
                while ((line = br.readLine()) != null) {
                    if (line.contains(word)) {
                        found = true;
                        break;
                    }
                }
                br.close();
                if (found) {
                    files.add(file.getName());
                }
            }
        }
        return files;
    }
}
