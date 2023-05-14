package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorController implements Initializable {

    @FXML
    private Button add;

    @FXML
    private TableColumn<Doctor,String> designationCol;

    @FXML
    private TextField doctorID;

    @FXML
    private Label doctorInfo;

    @FXML
    private TextField doctorName;
    @FXML
    private TextField appointment;

    @FXML
    private Button home;

    @FXML
    private TableColumn<Doctor, String> idCol;
    @FXML
    private TableColumn<Doctor,String> aCol;

    @FXML
    private TableColumn<Doctor,String > nameCol;

    @FXML
    private Button showlist;

    @FXML
    private TextField speciality;

    @FXML
    private TableView<Doctor> tableView;

    @FXML
    void goHome(ActionEvent event) throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene("afterLogin.fxml");
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<Doctor,String>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Doctor,String>("name"));
        designationCol.setCellValueFactory(new PropertyValueFactory<Doctor,String>("speciality"));
        aCol.setCellValueFactory(new PropertyValueFactory<Doctor,String>("appointment"));
        //setupTable();
    }
    @FXML
    void addInfo(ActionEvent event) throws IOException{
        String name = this.doctorID.getText();
        String id = this.doctorName.getText();
        String speciality = this.speciality.getText();
        String appointment = this.appointment.getText();
        String data = name + ","  + id + "," + speciality +"," +appointment+ "\n";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("doctor.txt", true));
            writer.write(data);
            writer.close();

        } catch (IOException var11) {
            var11.printStackTrace();
        }

    }


    @FXML
    void view(ActionEvent event) {
        this.tableView.getItems().clear();

        try {
            BufferedReader br = new BufferedReader(new FileReader("doctor.txt"));

            String line;
            try {
                while((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    String name = parts[0];
                    String id = parts[1];
                    String speciality = parts[2];
                    String appointment = parts[3];

                    Doctor data = new Doctor(name,id,speciality,appointment);
                    this.tableView.getItems().add(data);
                }
            } catch (Throwable var13) {
                try {
                    br.close();
                } catch (Throwable var12) {
                    var13.addSuppressed(var12);
                }

                throw var13;
            }

            br.close();
        } catch (IOException var14) {
            var14.printStackTrace();
        }

    }
    }


