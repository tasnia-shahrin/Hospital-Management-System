package com.example.oopproject;




public class Doctor {
    private final String name;

    private final String id;
    private final String speciality;



    public Doctor(String name, String id, String speciality) {
        this.name = name;

        this.id = id;

        this.speciality = speciality;

    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getSpeciality() {
        return speciality;
    }
}
