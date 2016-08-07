package JavaFX;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * Created by ernes on 03/08/2016.
 */
public class Content_About {
    public void about(Pane parent) {
        BorderPane pane = new BorderPane();
        Label lblToppic = new Label ("About");
        pane.setCenter(lblToppic);

        parent.getChildren().add(pane);
    }
}
