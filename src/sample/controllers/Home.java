package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

public class Home {
    @FXML
    Button btnSelect, btnAdmin;

    public void handleSelectPage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/select.fxml"));
        btnSelect.getScene().setRoot(root);
    }

    public void handleAdminPage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/admin.fxml"));
        btnAdmin.getScene().setRoot(root);
    }
}
