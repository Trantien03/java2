package com.class3;

import java.util.LinkedList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        LinkedList<Employee> linkedlist = new LinkedList<Employee>();

        Employee employee1 = new Employee("John Doe", "john.doe@example.com", "1234 Elm St");
        Employee employee2 = new Employee("Jane Smith", "jane.smith@example.com", "5678 Oak St");
        Employee employee3 = new Employee("Tom Brown", "tom.brown@example.com", "7890 Maple St");

        linkedlist.add(employee1);
        linkedlist.add(employee2);
        linkedlist.add(employee3);
        linkedlist.add(employee3);

        System.out.println("All items: " + linkedlist);

        linkedlist.add(new Employee("Tuan Nguyen",
                "tom.brown@example.com", "7890 Maple St"));

        System.out.println("All items: " + linkedlist);

        linkedlist.addFirst(new Employee("First Person",
                "tom.brown@example.com", "7890 Maple St"));

        System.out.println("All items: " + linkedlist);

        Employee emp = linkedlist.getLast();
        System.out.println("Last item : " + emp.toString());

        linkedlist.add(2, new Employee("2nd Position",
                "tom.brown@example.com", "7890 Maple St"));

        System.out.println("All items: " + linkedlist);

    }
}

