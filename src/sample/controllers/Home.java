package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.SQLException;

public class Home {
    @FXML
    private Button btnSelect, btnAdmin;

    // Pizza kiválasztása jelenet
    public void handleSelectPage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/select.fxml"));
        btnSelect.getScene().setRoot(root);
    }

    // Admin (azaz az aktív rendelések) jelenet
    public void handleAdminPage(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/admin.fxml"));
        Parent root = (Parent) loader.load();
        Admin controller = loader.<Admin>getController();
        controller.listActiveOrders();
        btnAdmin.getScene().setRoot(root);
    }
}
