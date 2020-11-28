package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Finish {
    @FXML
    private Button btnHome;
    @FXML
    private Text timestamp;

    private LocalDateTime deliveryTime = LocalDateTime.now().plusHours(1);

    public String getDeliveryTime() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm", Locale.ROOT);
        String formatter = format.format(this.deliveryTime);

        return formatter;
    }

    public void setDeliveryTimeText() {
        timestamp.setText(this.getDeliveryTime());
    }

    public void handleHomePage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
        btnHome.getScene().setRoot(root);
    }
}
