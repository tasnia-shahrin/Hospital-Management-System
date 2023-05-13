package com.example.oopproject;




public class Employee {
    private final String name;
    private final String id;
    private final String designation;


    public Employee(String name, String id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;

    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }
}
