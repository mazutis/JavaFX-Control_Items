package JavaFX;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by ernes on 10/07/2016.
 * Program to test BoxConfirm and BoxAlert
 */

public class GUI05_AlertBox extends Application{

    Stage window;
    Button button1, button2;

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Main");

        button1 = new Button ("Pop up alert box       ");
        button1.setOnAction (e-> {
            BoxAlert.display("Title of Window", "Alert Message");           //AlerBox
        });

        button2 = new Button("Pop up confirm box     ");
        button2.setOnAction(e -> {
            boolean result = BoxConfirm.display("Confirm","Do you want to take some action? ");
            System.out.println(result);
        });


        VBox layout1 = new VBox();
        layout1.getChildren().addAll(button1, button2);
        Scene scene = new Scene(layout1, 600, 600);
        window.setScene(scene);
        window.show();
    }

}