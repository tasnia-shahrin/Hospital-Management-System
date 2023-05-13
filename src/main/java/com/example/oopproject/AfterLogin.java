package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AfterLogin {

        @FXML
        private Button home;
        private Button doctor;
        private Button patient;
        private Button diagnosis;
        private Button employee;


        public void goHome(ActionEvent event) throws IOException {
           HelloApplication h = new HelloApplication();
           h.changeScene("hello-view.fxml");
        }
        public void doctorInfo(ActionEvent event) throws IOException {
            HelloApplication h = new HelloApplication();
            h.changeScene("doctor.fxml");
        }

       public void patientInfo(ActionEvent event) throws IOException{
           HelloApplication h = new HelloApplication();
           h.changeScene("patient.fxml");
       }
       public void diagnosisInfo(ActionEvent event) throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene("diagnosis.fxml");
    }
    public void employeeInfo(ActionEvent event) throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene("employee.fxml");
    }

    }


