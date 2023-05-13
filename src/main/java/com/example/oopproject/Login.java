package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Login {
    public Login(){

    }
    @FXML
    private Button Login;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    public void userLogin(ActionEvent event) throws IOException{
        checkLogin();
    }

    private void checkLogin() throws IOException{
        HelloApplication h = new HelloApplication();
        if(username.getText().toString().equals("receptionist") && password.getText().toString().equals("1234")){
            wrongLogin.setText("Success");
            h.changeScene("afterLogin.fxml");
        }
        else if(username.getText().isEmpty() && password.getText().isEmpty()){
            wrongLogin.setText("please enter your data");
        }
        else{
            wrongLogin.setText("wrong username or password");
        }
    }

}
