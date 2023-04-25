package com.class3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainClassMap {
    public static void main(String[] args) {
        HashMap<Integer, Employee> map = new HashMap();

        Employee employee1 = new Employee(1, "John Doe", "john.doe@example.com", "1234 Elm St");
        Employee employee2 = new Employee(2, "Jane Smith", "jane.smith@example.com", "5678 Oak St");
        Employee employee3 = new Employee(3, "Tom Brown", "tom.brown@example.com", "7890 Maple St");

        map.put(employee1.getId(), employee1);
        map.put(employee2.getId(), employee2);
        map.put(employee3.getId(), employee3);
        map.put(employee3.getId(), employee3);

        Iterator<Map.Entry<Integer, Employee>> it
                = map.entrySet().iterator();

        // Iterating every set of entry in the HashMap
        while (it.hasNext()) {
            Map.Entry<Integer, Employee> emp
                    = (Map.Entry<Integer, Employee>) it.next();

            // Displaying HashMap
            System.out.println(emp.getValue().toString());
        }

    }
}

