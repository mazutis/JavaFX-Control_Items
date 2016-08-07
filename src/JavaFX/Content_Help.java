package JavaFX;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * Created by ernes on 03/08/2016.
 */
public class Content_Help {
    public void help (Pane parent) {
        BorderPane pane = new BorderPane();
        Label lblToppic = new Label ("Help");
        pane.setCenter(lblToppic);

        parent.getChildren().add(pane);
    }
}