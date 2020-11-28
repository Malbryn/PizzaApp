package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import sample.MessageBox;
import sample.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Select {
    @FXML
    Button btnCart, btnOrder;
    @FXML
    RadioButton styleThin, styleThick, styleStuffed;
    @FXML
    RadioButton sizeSmall, sizeMedium, sizeLarge;
    @FXML
    RadioButton typeMargherita, typePepperoni, typeMeat, typeBBQ, typeHawaiian, typeMushroom;
    @FXML
    CheckBox extraPepperoni, extraBacon, extraOlives, extraHam, extraCheese, extraOnion;
    @FXML
    ToggleGroup groupStyle, groupSize, groupType;
    @FXML
    ListView itemList;

    Cart cart = new Cart();

    public boolean addToCart(ActionEvent actionEvent) {
        if (groupStyle.getSelectedToggle() == null) {
            MessageBox.show("Hiba", "Válassz tésztát!");
            return false;
        }

        if (groupSize.getSelectedToggle() == null) {
            MessageBox.show("Hiba", "Válassz méretet!");
            return false;
        }

        if (groupType.getSelectedToggle() == null) {
            MessageBox.show("Hiba", "Válassz pizza típust!");
            return false;
        }

        Pizza newPizza = createPizza();
        itemList.getItems().add(newPizza.toString());
        cart.addOrder(newPizza);

        return true;
    }

    public Pizza createPizza() {
        ArrayList<CheckBox> extras = new ArrayList<CheckBox>(
                Arrays.asList(extraPepperoni, extraBacon, extraOlives, extraHam, extraCheese, extraOnion)
        );
        ArrayList<PizzaExtra> selectedExtras = new ArrayList<PizzaExtra>();

        for (CheckBox check : extras) {
            if (check.isSelected()) {
                selectedExtras.add((PizzaExtra) check.getUserData());
            };
        }

        Pizza customPizza = new Pizza(
                (PizzaStyle) groupStyle.getSelectedToggle().getUserData(),
                (PizzaSize) groupSize.getSelectedToggle().getUserData(),
                (PizzaType) groupType.getSelectedToggle().getUserData(),
                selectedExtras
        );

        System.out.println(customPizza.toString());

        return customPizza;
    }

    public boolean handleOrderPage(ActionEvent actionEvent) throws IOException {
        if (cart.getOrder().size() == 0) {
            MessageBox.show("Hiba", "Válaszd ki a rendelni kívánt pizzát!");
            return false;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/order.fxml"));
        Parent root = (Parent) loader.load();
        Order controller = loader.<Order>getController();
        controller.setCart(this.cart);
        btnOrder.getScene().setRoot(root);

        return true;
    }
}
