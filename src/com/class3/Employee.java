package com.class3;

public class Employee implements Comparable {
    int id;
    String name;
    String email;
    String address;

    public Employee(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Employee(String name, String email, String address) {
        this.id = 0;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String toString() {
        return this.id +" : "+ this.name +", "+ this.email+","+this.address;
    }

    public Integer getId() {
        return new Integer(this.id);
    }

    @Override
    public int compareTo(Object o) {
        Employee other = (Employee) o;
        return this.name.compareTo(other.name);
    }
}

