package com.example.oopproject;

public class Doctor {

        private int id;
        private String name;
        private String speciality;


        public Doctor( int id, String name,String speciality) {
            this.id = id;
            this.name = name;
            this.speciality=speciality;

        }

        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
        public String toString() {
            return "Diagnosis{" +
                    "id=" + id +
                    ", designation='" + speciality + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


