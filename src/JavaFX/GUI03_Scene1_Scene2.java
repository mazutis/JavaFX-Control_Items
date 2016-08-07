package JavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by ernes on 04/07/2016.
 */
public class GUI03_Scene1_Scene2 extends Application {

    public static void main(String args[]) {
        launch(args);
    }
    Stage  windowMain;
    Scene scene1, scene2;
    Label label1 = new Label ("Welcome to scene 1");
    Button button1, button2;


    @Override
    public void start(Stage primaryStage) throws Exception {
        windowMain = primaryStage;

        button1 = new Button();
        button1.setText("Go to scene 2");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                windowMain.setScene(scene2);
                System.out.println ("Button 1 pressed / inner class");
            }
        });

        button2 = new Button();
        button2.setText("Go to scene 1");
        button2.setOnAction(e -> {
            windowMain.setScene(scene1);
            System.out.println("Button 2 pressed / inner class");
        });

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll( label1, button1);
        scene1 = new Scene(layout1, 800, 600); //new view

        VBox layout2 = new VBox();
        layout2.getChildren().addAll(button2);
        scene2 = new Scene(layout2, 400, 400); //new view

        windowMain.setScene(scene1);
        windowMain.setTitle("Main Stage");
        windowMain.show();
    }
}





