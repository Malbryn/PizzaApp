package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageBox {
    public static void show(String title, String message) {
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(300);
        stage.setMinHeight(125);

        Label label = new Label(message);
        Button btnOk = new Button("OK");

        btnOk.setOnAction(e -> stage.close());

        VBox pane = new VBox(20);
        pane.getChildren().addAll(label, btnOk);

        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane);
        stage.setScene(scene);

        stage.showAndWait();
    }
}