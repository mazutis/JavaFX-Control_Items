package JavaFX;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by ernes on 10/07/2016.
 */

public class BoxAlert {

    public static void display (String Tittle, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL); //Defines a modal window that blocks events from being delivered to any other application window.
        window.setTitle(Tittle);
        window.setMinWidth(250);
        System.out.println ("AlerBox activated");

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button ("Close");
        closeButton.setOnAction (e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}

