package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import sample.model.database.DatabaseConnection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
    @FXML
    private Button btnHome;

    public void handleHomePage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
        btnHome.getScene().setRoot(root);
    }

    public void listActiveOrders() throws SQLException {
        DatabaseConnection db = new DatabaseConnection("localhost", "pizzadelivery_db", "root", "");
        ResultSet rs = db.query("SELECT timestamp, name, address, phone_number, order_list, total FROM deliveries");

        while (rs.next()) {
            System.out.println(
                    rs.getString("timestamp") + " - " +
                    rs.getString("name") + " - " +
                    rs.getString("address") + " - " +
                    rs.getString("phone_number") + " - " +
                    rs.getString("order_list") + " - " +
                    rs.getString("total")
            );
        }

        db.close();
    }
}
