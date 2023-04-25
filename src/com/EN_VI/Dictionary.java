package com.EN_VI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class Dictionary {
    private static Map<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        loadData();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("======== Dictionary program ========");
            System.out.println("1. Add Word");
            System.out.println("2. Delete Word");
            System.out.println("3. Translate");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addWord();
                    break;
                case 2:
                    removeWord();
                    break;
                case 3:
                    translate();
                    break;
                case 4:
                    updateDatabase();
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    private static void addWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------- Add -------------");
        System.out.print("Enter English: ");
        String eng = scanner.nextLine();
        System.out.print("Enter Vietnamese: ");
        String vi = scanner.nextLine();
        if (dictionary.containsKey(eng)) {
            System.out.print("Word already exists. Do you want to update the meaning? (Y/N) ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                dictionary.put(eng, vi);
                System.out.println("Updated successfully!");
            }
        } else {
            dictionary.put(eng, vi);
            System.out.println("Added successfully!");
        }
    }

    private static void removeWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------ Delete ----------------");
        System.out.print("Enter English: ");
        String eng = scanner.nextLine();
        if (dictionary.containsKey(eng)) {
            dictionary.remove(eng);
            System.out.println("Deleted successfully!");
        } else {
            System.out.println("Key not found in db.");
        }
    }

    private static void translate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------- Translate ------------");
        System.out.print("Enter English: ");
        String eng = scanner.nextLine();
        if (dictionary.containsKey(eng)) {
            System.out.println("Vietnamese: " + dictionary.get(eng));
        } else {
            System.out.println("Empty.");
        }
    }

    private static void loadData() {
        try {
            FileInputStream fileIn = new FileInputStream("data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            dictionary = (HashMap<String, String>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            System.out.println("No data found. Starting with empty database.");
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found.");
            c.printStackTrace();
        }
    }

    private static void updateDatabase() {
        try {
            FileOutputStream fileOut = new FileOutputStream("data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(dictionary);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}