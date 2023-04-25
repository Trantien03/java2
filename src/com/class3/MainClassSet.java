package com.class3;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MainClassSet {
    public static void main(String[] args) {
        TreeSet<Employee> treeSet = new TreeSet<Employee>();

        Employee employee1 = new Employee("John Doe", "john.doe@example.com", "1234 Elm St");
        Employee employee2 = new Employee("Jane Smith", "jane.smith@example.com", "5678 Oak St");
        Employee employee3 = new Employee("Tom Brown", "tom.brown@example.com", "7890 Maple St");
        Employee employee4 = new Employee("Tuan Nguyen", "tom.brown@example.com", "7890 Maple St");

        treeSet.add(employee1);
        treeSet.add(employee2);
        treeSet.add(employee3);
        treeSet.add(employee4);
        treeSet.add(employee4);

        Iterator it = treeSet.iterator();

        while(it.hasNext()) {
            Employee item = (Employee)it.next();
            System.out.println(item.toString());
        }

    }
}

