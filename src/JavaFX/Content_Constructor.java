package JavaFX;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Created by ernes on 03/08/2016.
 */
public class Content_Constructor {
    public void constructor(Pane parent) {
        BorderPane pane = new BorderPane();
        Label lblToppic = new Label ("Constructors");
        lblToppic.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        pane.setCenter(lblToppic);

        Button btn6 = new Button("Constructor");
        btn6.setMinWidth(120);
        Label lbl6 = new Label ("Constructor from ClassD \n  ");
        btn6.setOnAction (e -> {
            ClassC constructor = new ClassC(100);
            System.out.println ("ClassC constructor is: " + constructor.getNumber());
        });

        parent.getChildren().addAll(pane, btn6, lbl6);
    }
}
