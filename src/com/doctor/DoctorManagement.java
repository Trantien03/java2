package com.doctor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DoctorManagement {
    HashMap<String, Doctor> mapDoctors;

    DoctorManagement() {
        mapDoctors = new HashMap<>();
    }

    DoctorManagement(HashMap<String, Doctor> map) {
        this.mapDoctors = map;
    }

    public void viewAllDoctors() throws Exception {
        Iterator iter = this.mapDoctors.entrySet().iterator();

        while(iter.hasNext()) {
            Map.Entry<String, Doctor> entry
                    = (Map.Entry<String, Doctor>) iter.next();
            entry.getValue().display();
        }
    }

    public Doctor findDoctorByKey(String code) {
        if( this.mapDoctors.containsKey(code) ) {
            return this.mapDoctors.get(code);
        }
        return null;
    }

    public boolean updateDoctor(Doctor doctor) throws Exception {
        // Write code here

        this.mapDoctors.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean addDoctor(Doctor doctor) throws Exception {
        // Write code here
        if(this.mapDoctors.containsKey(doctor.getCode())) {
            throw new Exception("Doctor existing");
        }
        this.mapDoctors.put(doctor.getCode(), doctor);
        return true;
    }

    public HashMap<String, Doctor> searchDoctor(String input)
            throws Exception {

        HashMap<String, Doctor> result = new HashMap<>();

        if(input == null || input.equals("")) {
            throw new Exception("Keyword to find can not be empty");
        } else {
            for(Doctor item : this.mapDoctors.values()) {
                if(item.getCode().contains(input)) {
                    result.put(item.getCode(), item);
                    System.out.println("Found code");
                } else if(item.getName().contains(input)) {
                    result.put(item.getCode(), item);
                    System.out.println("Found name");
                } else if(item.getSpecialization().contains(input)) {
                    result.put(item.getCode(), item);
                    System.out.println("Found spec");
                }
            }
        }

        return result;
    }

}

