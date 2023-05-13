package com.example.oopproject;




public class Diagnosis {
    private final String name;
    private final String id;
    private final String diagnosis;
    private final String medicine;


    public Diagnosis(String name, String id, String diagnosis, String medicine) {
        this.name = name;
        this.id = id;
        this.diagnosis = diagnosis;
        this.medicine = medicine;

    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getMedicine() {
        return medicine;
    }
}
