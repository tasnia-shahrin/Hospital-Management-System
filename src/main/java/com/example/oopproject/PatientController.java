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

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PatientController implements Initializable {

    @FXML
    private TextField BloodGroup; //1

    @FXML
    public Button showlist;

    @FXML
    private Button add;

    @FXML
    private TextField age;//2

    @FXML
    private TableColumn<Patient,String> ageCol;

    @FXML
    private TableColumn<Patient,String> bgCol;

    @FXML
    private Button home;


    @FXML
    private TableColumn<Patient, String> idCol;

    @FXML
    private TableColumn<Patient, String> nameCol;

    @FXML
    private TextField patientID;//3

    @FXML
    private Label patientInfo;

    @FXML
    private TextField patientName; //4

    @FXML
    private TableColumn<Patient, String> phnCol;

    @FXML
    private TextField phone;//5

    @FXML
    private TableView<Patient> tableView;


    @FXML
    public void goHome(ActionEvent event) throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene("afterLogin.fxml");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("name"));
        phnCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("phone"));
        bgCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("blood"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("age"));
        //setupTable();
    }
    public void addInfo(ActionEvent event) {

        String blood = this.BloodGroup.getText();
        String age = this.age.getText();
        String id = this.patientID.getText();
        String phone = this.phone.getText();
        String name = this.patientName.getText();
        String data = name + "," + age + "," + id + "," + blood + "," + phone + "\n";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("patient.txt", true));
            writer.write(data);
            writer.close();
            // this.msglabel.setText("Post successful!");
        } catch (IOException var11) {
            var11.printStackTrace();
        }

    }
    //    @FXML
//    void addInfo(ActionEvent event) {
//        ObservableList<Patient> currentTableData = tableView.getItems();
//        int currentPatientId = Integer.parseInt(patientID.getText());
//        int currentPatientAge = Integer.parseInt(age.getText());
//        for (Patient p : currentTableData) {
//            if (p.getId() == currentPatientId) {
//                p.setName(patientName.getText());
//                p.setAge(currentPatientAge);
//                p.setBloodGroup(BloodGroup.getText());
//                p.setPhone(phone.getText());
//                tableView.setItems(currentTableData);
//                tableView.refresh();
//                break;
//            }
//        }
//    }
    @FXML
    public void view(ActionEvent event) {
        this.tableView.getItems().clear();

        try {
            BufferedReader br = new BufferedReader(new FileReader("patient.txt"));

            String line;
            try {
                while((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    String name = parts[0];
                    String age = parts[1];
                    String id = parts[2];
                    String blood = parts[3];
                    String phone = parts[4];

                    Patient data = new Patient(name,age,id,blood,phone);
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

//    @FXML
//    void addInfo(MouseEvent event){
//        Patient clickedPatient =  tableView.getSelectionModel().getSelectedItem();
//        patientID.setText(String.valueOf(clickedPatient.getId()));
//        patientName.setText(String.valueOf(clickedPatient.getName()));
//        BloodGroup.setText(String.valueOf(clickedPatient.getBloodGroup()));
//        phone.setText(String.valueOf(clickedPatient.getPhone()));
//        age.setText(String.valueOf(clickedPatient.getAge()));
//    }
//    private void setupTable(){
//        Patient p1 = new Patient(101,"suraiya","A+","013930393939",22);
//        Patient p2 = new Patient(102,"amira","B-","013034i92040",34);
//        Patient p3 = new Patient(103,"anannya","AB+","01948947320",9);
//        Patient p4 = new Patient(104,"anan","O+","013940350010",32);
//        tableView.getItems().addAll(p1);
//        tableView.getItems().addAll(p2);
//        tableView.getItems().addAll(p3);
//        tableView.getItems().addAll(p4);
//    }

}
