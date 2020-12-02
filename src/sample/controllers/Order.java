package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.MessageBox;
import sample.model.Cart;
import sample.model.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Order {
    @FXML
    private Button btnFinish;
    @FXML
    private TextField inputName, inputZipCode, inputCity, inputStreet, inputHouseNumber, inputPhonenumber;
    private Cart cart;

    // Beolvassuk az input adatokat és példányosítjuk a Customer osztályt
    // Váltunk a Finish jelenetre
    public boolean handleFinishPage(ActionEvent actionEvent) throws IOException {
        ArrayList<TextField> inputFields = new ArrayList<TextField>(
                Arrays.asList(inputName, inputZipCode, inputCity, inputStreet, inputHouseNumber, inputPhonenumber)
        );

        for (TextField f : inputFields) {
            if (f.getText().trim().isEmpty()) {
                MessageBox.show("Hiba", "Minden mezőt ki kell tölteni!");
                return false;
            }
        }

        if (!isInt(inputZipCode, "Hibás irányítószám")) return false;

        Customer newCustomer = new Customer(
                inputName.getText().trim(),
                inputZipCode.getText().trim(),
                inputCity.getText().trim(),
                inputStreet.getText().trim(),
                inputHouseNumber.getText().trim(),
                inputPhonenumber.getText().trim()
        );

        newCustomer.setOrder(this.cart);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/finish.fxml"));
        Parent root = (Parent) loader.load();
        Finish controller = loader.<Finish>getController();
        controller.setDeliveryTimeText();
        controller.addToDatabase(newCustomer);
        btnFinish.getScene().setRoot(root);

        return true;
    }

    // Integer vizsgálat segédmetódus
    private boolean isInt(TextField f, String msg) {
        try {
            Integer.parseInt(f.getText());
            return true;
        } catch(NumberFormatException e) {
            MessageBox.show("Hiba", msg);
            return false;
        }
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
