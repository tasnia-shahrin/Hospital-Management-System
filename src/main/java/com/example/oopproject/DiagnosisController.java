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

public class DiagnosisController implements Initializable {

    @FXML
    private TextField ID;

    @FXML
    private Button add;

    @FXML
    private TableColumn<Diagnosis, String> dCol;

    @FXML
    private TextField diagnosis;

    @FXML
    private Label diagnosisInfo;

    @FXML
    private Button home;

    @FXML
    private TableColumn<Diagnosis,Integer> idCol;

    @FXML
    private TableColumn<Diagnosis, String> medCol;

    @FXML
    private TextField medicines;

    @FXML
    private TextField name;

    @FXML
    private TableColumn<Diagnosis, String> nameCol;

    @FXML
    private TableView<Diagnosis> tableView;



    @FXML

        public void goHome(ActionEvent event) throws IOException {
            HelloApplication h = new HelloApplication();
            h.changeScene("afterLogin.fxml");
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<Diagnosis,Integer>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Diagnosis,String>("name"));
        dCol.setCellValueFactory(new PropertyValueFactory<Diagnosis,String>("diagnosis"));
        medCol.setCellValueFactory(new PropertyValueFactory<Diagnosis,String>("medicines"));
        setupTable();
    }

    @FXML
    void addInfo(ActionEvent event) {
        ObservableList<Diagnosis> currentTableData = tableView.getItems();
        int currentPatientId = Integer.parseInt(ID.getText());
        for (Diagnosis d : currentTableData) {
            if (d.getId() == currentPatientId ) {
                    d.setName(name.getText());
                    d.setMedicines(medicines.getText());
                    d.setDiagnosis(diagnosis.getText());
                    tableView.setItems(currentTableData);
                    tableView.refresh();
                    break;
                }

        }
    }
    @FXML
    void addInfo(MouseEvent event){
        Diagnosis clickedDiagnosis =  tableView.getSelectionModel().getSelectedItem();
        ID.setText(String.valueOf(clickedDiagnosis.getId()));
        name.setText(String.valueOf(clickedDiagnosis.getName()));
        diagnosis.setText(String.valueOf(clickedDiagnosis.getDiagnosis()));
        medicines.setText(String.valueOf(clickedDiagnosis.getMedicines()));
    }
    private void setupTable(){
        Diagnosis d1 = new Diagnosis(101,"suraiya","headache","advil");
        Diagnosis d2 = new Diagnosis(102,"amira","cough","tofen");
        Diagnosis d3 = new Diagnosis(103,"anannya","headache","advil");
        Diagnosis d4 = new Diagnosis(104,"anan","anemia","iron injection");
        tableView.getItems().addAll(d1);
        tableView.getItems().addAll(d2);
        tableView.getItems().addAll(d3);
        tableView.getItems().addAll(d4);
    }
}


