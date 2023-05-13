package com.example.oopproject;

public class Patient {
        private int id;
        private String name;
        private String bloodGroup;
        private String phone;
        private int age;

        public Patient( int id, String name,String bloodGroup,String phone,int age) {
            this.id = id;
            this.name = name;
            this.bloodGroup=bloodGroup;
            this.phone=phone;
            this.age=age;
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

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
        public String toString() {
            return "Diagnosis{" +
                    "id=" + id +
                    ", phone='" + phone + '\'' +
                    ", name='" + name + '\'' +
                    ", bloodGroup='" + bloodGroup + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }




