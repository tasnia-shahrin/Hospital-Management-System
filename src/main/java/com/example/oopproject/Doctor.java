package com.example.oopproject;




public class Doctor {
    private final String name;

    private final String id;
    private final String speciality;

    private final String appointment;

    public Doctor(String name, String id, String speciality,String appointment) {
        this.name = name;

        this.id = id;

        this.speciality = speciality;
        this.appointment=appointment;

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

    public String getAppointment() {
        return appointment;
    }
}
