package JavaFX;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.Random;
import static javafx.scene.paint.Color.GREY;
import static javafx.scene.paint.Color.PALEGOLDENROD;

/**
 * Created by ernes on 10/07/2016.
 */
public class BoxRandomNumber {

    int result;

    public int display (){

        int min = 1; //Default min number
        int max = 7; //Default max number

        Stage window = new Stage();
        window.setTitle("Random");
        window.setMinWidth(250);
        System.out.println ("RandomNumber Box activated");

        Label labelMin = new Label("Lowest number: ");
        labelMin.setTextFill(GREY);

        Label labelMax = new Label("Highest number: " );
        labelMax.setTextFill(GREY);

        TextField tfMin = new TextField (String.valueOf(min)); //Default min number
        int newMinMin = Integer.parseInt(tfMin.getText());

        TextField tfMax = new TextField (String.valueOf(max)); //Default max number

        Label labelNumber = new Label();
        labelNumber.setFont(Font.font("Verdana", FontWeight.BOLD, 100));

        Button btnGenerate = new Button ("Generate new random number");
        btnGenerate.setMinHeight(30);


        btnGenerate.setOnAction (e -> {
            Random randomDice = new Random();


            boolean validation1 = IntValidation (tfMin);
            boolean validation2 = IntValidation (tfMax);


            if (validation1&&validation2) {
                int newMin = Integer.parseInt(tfMin.getText());
                int newMax = Integer.parseInt(tfMax.getText());
                if (newMin<=newMax) {
                    int interval =  newMax - newMin +1;
                    int x = randomDice.nextInt(interval);
                    result = x+newMin;
                    labelNumber.setText("" + result);
                    System.out.println("Random number generated: " + result);
                }
                else {
                    BoxAlert.display("Error", "   Lowest number can not be higher than Highest!    ");
                }
            }
            else {
                BoxAlert.display("Error", "   Lowest or Highest number is not correct!    ");
            }
        });

        GridPane layout0 = new GridPane();
        layout0.setAlignment(Pos.TOP_CENTER);
        layout0.setVgap(5);
        layout0.setHgap(5);
        layout0.setPadding(new Insets(10, 10, 10, 10));
        layout0.getChildren().addAll(labelMin, labelMax, labelNumber, btnGenerate,tfMin,tfMax);

        layout0.setConstraints(labelNumber, 1, 0 ); // colum, line
        layout0.setConstraints(btnGenerate, 1, 2 );
        layout0.setConstraints(labelMin,0, 1 );
        layout0.setConstraints(labelMax,2, 1 );
        layout0.setConstraints(tfMin, 0, 2);
        layout0.setConstraints(tfMax, 2, 2);
        layout0.setHalignment(labelNumber, HPos.CENTER);

        Scene scene = new Scene(layout0, 550, 250);
        window.setScene(scene);
        window.showAndWait();

        return result;
    }

    private static boolean IntValidation (TextField link) {
        try{
            int valid = Integer.parseInt(link.getText());
            return true;
        }catch(NumberFormatException e) {
            System.out.println("Error: " + link.getText() + " is not number");
            return false;
        }
    }
}


