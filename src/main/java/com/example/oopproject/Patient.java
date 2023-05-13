package com.example.oopproject;




public class Patient {
    private final String name;
    private final String age;
    private final String id;
    private final String blood;
    private final String phone;


    public Patient(String name, String age, String id, String blood, String phone) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.blood = blood;
        this.phone = phone;

    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getBlood() {
        return blood;
    }

    public String getPhone() {
        return phone;
    }
}
