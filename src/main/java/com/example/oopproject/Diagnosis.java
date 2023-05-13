package com.example.oopproject;

public class Diagnosis {

        private int id;
        private String name;
        private String diagnosis;
        private String medicines;

        public Diagnosis( int id, String name,String diagnosis,String medicines) {
            this.id = id;
            this.name = name;
            this.diagnosis=diagnosis;
            this.medicines=medicines;
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

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    @Override
        public String toString() {
            return "Diagnosis{" +
            "id=" + id +
                    ", diagnosis='" + diagnosis + '\'' +
                    ", name='" + name + '\'' +
                    ", medicines='" + medicines + '\'' +
                    '}';
        }
    }


