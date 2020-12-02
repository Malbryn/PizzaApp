package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import sample.model.DatabaseConnection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Admin {
    @FXML
    private Button btnHome;
    @FXML
    private ListView currentOrders;

    // Váltás a kezdőképernyőre
    public void handleHomePage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
        btnHome.getScene().setRoot(root);
    }

    // Az aktív megrendelések kilistázása (< 1 óra telt el a megrendelés óta)
    public void listActiveOrders() throws SQLException {
        DatabaseConnection db = new DatabaseConnection("localhost", "pizzadelivery_db", "root", "");
        ResultSet rs = db.query("SELECT timestamp, name, address, phone_number, order_list, total FROM deliveries");

        while (rs.next()) {
            // Mostani idő
            Timestamp current = Timestamp.valueOf(LocalDateTime.now());

            // Ha még csak 0 óra telt el, akkor még aktív a rendelés
            if (getTimestampDiff(rs.getTimestamp("timestamp"), current) == 0) {
                currentOrders.getItems().add(
                        rs.getString("timestamp") + " - " +
                        rs.getString("name") + " - " +
                        rs.getString("address") + " - " +
                        rs.getString("phone_number") + " - " +
                        rs.getString("order_list") + " - " +
                        rs.getString("total")
                );
            }
        }

        db.close();
    }

    private static long getTimestampDiff(Timestamp original, Timestamp current) {
        long diff = current.getTime() - original.getTime();
        return TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
