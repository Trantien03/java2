package com.doctor;

import java.util.HashMap;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

//        HashMap<String, Doctor> mapDoctors = new HashMap<>();
//        DoctorManagement management = new DoctorManagement(mapDoctors);

        DoctorManagement management = new DoctorManagement();
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("========= Doctor Management ==========");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. View all Doctors");
            System.out.println("6. Exit");
            System.out.print("Please choice one option: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                Doctor doctor = null;
                switch (choice) {
                    case 1:{
                        System.out.println("-------- Add Doctor --------");
                        doctor = new Doctor();
                        System.out.print("Enter Code: ");
                        doctor.setCode(scanner.nextLine());
                        System.out.print("Enter Name: ");
                        doctor.setName(scanner.nextLine());
                        System.out.print("Enter Specialization: ");
                        doctor.setSpecialization(scanner.nextLine());

                        try {
                            if( management.addDoctor( doctor ) ) {
                                System.out.println("New doctor created");
                            }
                        } catch (Exception e ) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                    case 2: {
                        System.out.println("-------- Update Doctor --------");
                        doctor = new Doctor();
                        System.out.print("Enter Code to find: ");
                        String code = scanner.nextLine();
                        Doctor updatingDoctor = management.findDoctorByKey( code );
                        if( updatingDoctor != null ) {
                            System.out.print("Enter Name: ");
                            updatingDoctor.setName(scanner.nextLine());
                            System.out.print("Enter Specialization: ");
                            updatingDoctor.setSpecialization(scanner.nextLine());

                            System.out.println("Doctor updated");
                        } else {
                            System.out.println("Not found Doctor");
                        }
                    }
                    break;
                    case 4: {
                        System.out.println("-------- Search Doctor --------");
                        System.out.print("Enter key word: ");
                        String keyWord = scanner.nextLine();
                        try {
                            HashMap<String, Doctor> resultDoctor = management.searchDoctor(keyWord);
                            if( resultDoctor.size() > 0 ) {
                                for(Doctor item : resultDoctor.values()) {
                                    item.display();
                                }
                            } else {
                                System.out.println("Not found any Doctor");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 5: {
                        try {
                            management.viewAllDoctors();
                        } catch (Exception e ) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                }

            } catch (NumberFormatException e) {
                System.out.println("Please choice 1-5");
            }

        } while(true);
    }
}

