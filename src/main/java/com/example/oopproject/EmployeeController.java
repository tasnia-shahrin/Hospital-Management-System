package com.example.oopproject;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {


    @FXML
    private Button add;

    @FXML
    private TableColumn<Employee,String> dCol;

    @FXML
    private TextField designation;

    @FXML
    private TextField employeeID;

    @FXML
    private TextField employeeName;
    @FXML
    private Label employeeInfo;

    @FXML
    private Button home;

    @FXML
    private TableColumn<Employee,String > idCol;

    @FXML
    private TableColumn<Employee, String> nameCol;

    @FXML
    private Button showlist;

    @FXML
    private TableView<Employee> tableview;

    @FXML
    void goHome(ActionEvent event)throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene("afterLogin.fxml");
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
        dCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("designation"));

        //setupTable();
    }
    @FXML
    void addInfo(ActionEvent event)throws IOException {
        String id = this.employeeID.getText();
        String name = this.employeeName.getText();
        String designation = this.designation.getText();
        String data = name + ","  + id + "," + designation + "\n";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("employee.txt", true));
            writer.write(data);
            writer.close();

        } catch (IOException var11) {
            var11.printStackTrace();
        }
    }
    @FXML
    void view(ActionEvent event) {
        this.tableview.getItems().clear();

        try {
            BufferedReader br = new BufferedReader(new FileReader("employee.txt"));

            String line;
            try {
                while((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    String name = parts[0];
                    String id = parts[1];
                    String designation = parts[2];

                    Employee data = new Employee(name,id,designation);
                    this.tableview.getItems().add(data);
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