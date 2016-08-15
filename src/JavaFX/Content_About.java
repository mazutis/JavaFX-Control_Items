package JavaFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

        pane.setPadding(new Insets(10,10,10,10));

        Label lblContent = new Label ("This program has been fallowed by \n " +
                "thenewboston tutorials: JavaFX Java GUI Tutorial from Youtube");

        pane.setTop(lblToppic);
        pane.setLeft(lblContent);

        parent.getChildren().add(pane);
    }
}
