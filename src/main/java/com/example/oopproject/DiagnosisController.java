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

public class DiagnosisController implements Initializable {

    @FXML
    private TextField ID;

    @FXML
    private Button add;

    @FXML
    private TableColumn<Diagnosis,String> dCol;

    @FXML
    private TextField diagnosis;

    @FXML
    private Label diagnosisInfo;

    @FXML
    private Button home;

    @FXML
    private TableColumn<Diagnosis,String> idCol;

    @FXML
    private TableColumn<Diagnosis, String> medCol;

    @FXML
    private TextField medicines;

    @FXML
    private TextField name;

    @FXML
    private TableColumn<Diagnosis, String> nameCol;

    @FXML
    private Button showlist;

    @FXML
    private TableView<Diagnosis> tableView;

    @FXML
    void goHome(ActionEvent event) throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene("afterLogin.fxml");
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<Diagnosis,String>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Diagnosis,String>("name"));
        dCol.setCellValueFactory(new PropertyValueFactory<Diagnosis,String>("diagnosis"));
        medCol.setCellValueFactory(new PropertyValueFactory<Diagnosis,String>("medicine"));
        //setupTable();
    }
    @FXML
    void addInfo(ActionEvent event) throws IOException{
        String id = this.ID.getText();
        String name = this.name.getText();
        String medicine = this.medicines.getText();
        String diagnosis = this.diagnosis.getText();
        String data = name + ","  + id + "," + diagnosis + "," + medicine + "\n";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("diagnosis.txt", true));
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
            BufferedReader br = new BufferedReader(new FileReader("diagnosis.txt"));

            String line;
            try {
                while((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    String name = parts[0];
                    String id = parts[1];
                    String diagnosis = parts[2];
                    String medicine = parts[3];

                    Diagnosis data = new Diagnosis(name,id,diagnosis,medicine);
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


