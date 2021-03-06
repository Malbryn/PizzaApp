package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import sample.model.Customer;
import sample.model.DatabaseConnection;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Finish {
    @FXML
    private Button btnHome;
    @FXML
    private Text timestamp;

    // Várható kiszállítási idő (= 1 óra)
    private LocalDateTime deliveryTime = LocalDateTime.now().plusHours(1);

    // Kiszállítási idő formázva
    public String getDeliveryTime() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm", Locale.ROOT);
        String formatter = format.format(this.deliveryTime);

        return formatter;
    }

    public void setDeliveryTimeText() {
        timestamp.setText(this.getDeliveryTime());
    }

    // Kezdőlapra váltás
    public void handleHomePage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
        btnHome.getScene().setRoot(root);
    }

    // Felvisszük a rendelést az adatbázisba
    public void addToDatabase(Customer customer) {
        DatabaseConnection db = new DatabaseConnection("localhost", "pizzadelivery_db", "root", "");
        db.modify("INSERT INTO deliveries (timestamp, name, address, phone_number, order_list, total) VALUES (?, ?, ?, ?, ?, ?)",
                new String[] {
                        LocalDateTime.now().toString(),
                        customer.getName(),
                        customer.getAddress(),
                        customer.getPhoneNumber(),
                        customer.getOrder().getOrderString(),
                        Integer.toString(customer.getOrder().getTotal())
                }
        );

        db.close();
    }
}
