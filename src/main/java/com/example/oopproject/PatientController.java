package com.example.oopproject;

import javafx.collections.ObservableList;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PatientController implements Initializable {

    @FXML
    private TextField BloodGroup;

    @FXML
    private Button add;

    @FXML
    private TextField age;

    @FXML
    private TableColumn<Patient,Integer> ageCol;

    @FXML
    private TableColumn<Patient,String> bgCol;

    @FXML
    private Button home;

    @FXML
    private TableColumn<Patient, Integer> idCol;

    @FXML
    private TableColumn<Patient, String> nameCol;

    @FXML
    private TextField patientID;

    @FXML
    private Label patientInfo;

    @FXML
    private TextField patientName;

    @FXML
    private TableColumn<Patient, String> phnCol;

    @FXML
    private TextField phone;

    @FXML
    private TableView<Patient> tableView;


    @FXML
    public void goHome(ActionEvent event) throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene("afterLogin.fxml");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("name"));
        phnCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("phone"));
        bgCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("bloodGroup"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("age"));
        setupTable();
    }
    @FXML
    void addInfo(ActionEvent event) {
        ObservableList<Patient> currentTableData = tableView.getItems();
        int currentPatientId = Integer.parseInt(patientID.getText());
        int currentPatientAge = Integer.parseInt(age.getText());
        for (Patient p : currentTableData) {
            if (p.getId() == currentPatientId) {
                p.setName(patientName.getText());
                p.setAge(currentPatientAge);
                p.setBloodGroup(BloodGroup.getText());
                p.setPhone(phone.getText());
                tableView.setItems(currentTableData);
                tableView.refresh();
                break;
            }
        }
    }
    @FXML
    void addInfo(MouseEvent event){
        Patient clickedPatient =  tableView.getSelectionModel().getSelectedItem();
        patientID.setText(String.valueOf(clickedPatient.getId()));
        patientName.setText(String.valueOf(clickedPatient.getName()));
        BloodGroup.setText(String.valueOf(clickedPatient.getBloodGroup()));
        phone.setText(String.valueOf(clickedPatient.getPhone()));
        age.setText(String.valueOf(clickedPatient.getAge()));
    }
    private void setupTable(){
        Patient p1 = new Patient(101,"suraiya","A+","013930393939",22);
        Patient p2 = new Patient(102,"amira","B-","013034i92040",34);
        Patient p3 = new Patient(103,"anannya","AB+","01948947320",9);
        Patient p4 = new Patient(104,"anan","O+","013940350010",32);
        tableView.getItems().addAll(p1);
        tableView.getItems().addAll(p2);
        tableView.getItems().addAll(p3);
        tableView.getItems().addAll(p4);
    }

}
