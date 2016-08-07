package JavaFX;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by ernes on 10/07/2016.
 */

public class BoxConfirm {

    static boolean answer;

    public static boolean display(String title, String message) {
        Stage window = new Stage();

        int xx = 5;

        window.initModality(Modality.APPLICATION_MODAL); //Defines a modal window that blocks events from being delivered to any other application window.
        window.setTitle(title);
        window.setMinWidth(250);
        System.out.println ("BoxConfirm activated");

        Label label = new Label();
        label.setText(message);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        HBox layout01 = new HBox(10);
        layout01.getChildren().addAll(yesButton, noButton);
        layout01.setAlignment(Pos.CENTER);

        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(label, layout01);
        layout1.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout1, 250, 100);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

}

