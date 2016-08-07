package JavaFX;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Scanner;

/**
 * Created by ernes on 03/08/2016.
 */
public class Content_Methods {
    Scanner input = new Scanner(System.in);

    public void methods(Pane parent) {
        ClassB objectB = new ClassB();
        ClassC objectC = new ClassC(1);

        BorderPane pane = new BorderPane();
        Label lblToppic = new Label ("Methods");
        lblToppic.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        pane.setCenter(lblToppic);

        Button btn1 = new Button();
        btn1.setText("Method1");
        btn1.setMinWidth(120);
        Label lbl1 = new Label("System.out.println method 1 inside Class B \n    ");
        btn1.setOnAction(e-> {
                    objectB.met1();
                    BoxAlert.display("Message", "          Method 1 inside ClassB has been executed          ");
                }
        );

        Button btn2 = new Button();
        btn2.setText("Method2");
        btn2.setMinWidth(120);
        Label lbl2 = new Label ("System.out.println method2 inside Class B \n    ");
        btn2.setOnAction(e->{objectB.met2();}
        );

        Button btn3 = new Button("Method3");
        btn3.setMinWidth(120);
        Label lbl3 = new Label("Aler Box test. And ClassB method3 action - number to system will be stored) \n     ");
        btn3.setOnAction (e -> {
            BoxAlert.display("Message","Enter number to system window.");
            System.out.println("Method3|Please enter number: ");
            int systemInput = input.nextInt();
            objectB.met3(systemInput);
            objectC.setNumber(systemInput);
        });

        Button btn4 = new Button("Method4");
        btn4.setMinWidth(120);
        Label lbl4 = new Label ("Get public variable (not method) from ClassC inner of ClassB \n  ");
        btn4.setOnAction(e -> {String z = objectB.z;
            System.out.println(z);
        });

        Button btn5 = new Button("getNumber");
        btn5.setMinWidth(120);
        Label lbl5 = new Label("Retrieve number stored in system due Method 3 action from ClassC\n  ");
        btn5.setOnAction (e -> {
            System.out.println("Number stored in system:" + objectC.getNumber());
        });

        parent.getChildren().addAll(pane, btn1, lbl1, btn2, lbl2, btn3, lbl3, btn4, lbl4, btn5, lbl5);
    }
}
