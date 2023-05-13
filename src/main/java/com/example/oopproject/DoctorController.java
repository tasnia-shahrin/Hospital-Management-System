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

public class DoctorController implements Initializable {

    @FXML
    private Button add;

    @FXML
    private TextField speciality;

    @FXML
    private TableColumn<Doctor,String> designationCol;

    @FXML
    private TextField doctorID;

    @FXML
    private Label doctorInfo;

    @FXML
    private TextField doctorName;

    @FXML
    private Button home;

    @FXML
    private TableColumn<Doctor,Integer> idCol;

    @FXML
    private TableColumn<Doctor,String> nameCol;

    @FXML
    private TableView<Doctor> tableView;

    @FXML

    public void goHome(ActionEvent event) throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene("afterLogin.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<Doctor,Integer>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Doctor,String>("name"));
        designationCol.setCellValueFactory(new PropertyValueFactory<Doctor,String>("speciality"));
        setupTable();
    }

    @FXML
    void addInfo(ActionEvent event) {
        ObservableList<Doctor> currentTableData = tableView.getItems();
        int currentPatientId = Integer.parseInt(doctorID.getText());
        for (Doctor d : currentTableData) {
            if (d.getId() == currentPatientId) {
                d.setName(doctorName.getText());
                d.setSpeciality(speciality.getText());
                tableView.setItems(currentTableData);
                tableView.refresh();
                break;
            }
        }
    }
    @FXML
    void addInfo(MouseEvent event){
        Doctor clickedDiagnosis =  tableView.getSelectionModel().getSelectedItem();
        doctorID.setText(String.valueOf(clickedDiagnosis.getId()));
        doctorName.setText(String.valueOf(clickedDiagnosis.getName()));
        speciality.setText(String.valueOf(clickedDiagnosis.getSpeciality()));
    }
    private void setupTable(){
        Doctor d1 = new Doctor(122,"Adiba","surgeon");
        Doctor d2 = new Doctor(132,"amira","gynecologist");
        Doctor d3 = new Doctor(103,"tanha","Neurosurgeon");

        tableView.getItems().addAll(d1);
        tableView.getItems().addAll(d2);
        tableView.getItems().addAll(d3);

    }
}




