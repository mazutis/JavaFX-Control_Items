package JavaFX;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by ernes on 03/08/2016.
 */
//Properties from ClassD
public class Content_Properties {
    public void properties (Pane parent) {

        //Set and read Properties
        ClassD classD = new ClassD();
        classD.firstNameProperty().addListener ( (v, oldValue, newValue) ->  {
            System.out.println("New value is: " + newValue);
            System.out.println("firstNameProperty():" + classD.firstNameProperty());
            System.out.println("getFirstName: " + classD.getFirstName());
        });
        Button btnFirstName = new Button("Set First Name from Content_Properties.java");
        btnFirstName.setOnAction ( e-> {
            classD.setFirstName("Michael");
        });

        //Bind properties:
        System.out.println ("Binding properties. Content_Properties.");
        IntegerProperty x = new SimpleIntegerProperty(5);
        IntegerProperty y = new SimpleIntegerProperty();

        y.bind(x.multiply(10));

        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue() + "\n " );

        x.setValue(6);
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue() + "\n " );

        //Binded input and labels
        Label lblFirstBind = new Label("Binding: ");
        Label lblSecondBind = new Label();
        TextField tfBind = new TextField();
        tfBind.setMaxWidth(250);

        lblSecondBind.textProperty().bind(tfBind.textProperty());

        HBox layoutBottom = new HBox();
        layoutBottom.setAlignment(Pos.BASELINE_LEFT);
        layoutBottom.getChildren().addAll(lblFirstBind, lblSecondBind, tfBind);



        BorderPane pane = new BorderPane();
        Label lblToppic = new Label ("Properties");
        pane.setTop(lblToppic);
        VBox layoutLeft = new VBox();
        layoutLeft.getChildren().addAll(btnFirstName);
        pane.setLeft(layoutLeft);
        pane.setBottom(layoutBottom);
        parent.getChildren().add(pane);
    }
}