package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

public class Select {
    @FXML
    Button btnOrder;

    public void addToCart(ActionEvent actionEvent) {
    }

    public void handleOrderPage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/order.fxml"));
        btnOrder.getScene().setRoot(root);
    }
}
