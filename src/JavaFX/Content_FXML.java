package JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by ernes on 10/07/2016.
 */

public class Content_FXML extends Application {

    //POP UP
   /*public static void display () {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); //Defines a modal window that blocks events from being delivered to any other application window.
        window.setTitle("FXML");
        window.setMinWidth(250);
        System.out.println ("Menu Item FXML activated");

        VBox layout = new VBox(10);

        layout.getChildren().addAll(            );
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void main (String[] args) {
        launch(args);
    }
    */

   //Load into the window
   public void fxml (Pane parent) throws Exception {
       parent.getChildren().add(FXMLLoader.load(getClass().getResource("Content_FXML.fxml")));
   }


    //Direct Runt for test purposes Content_FXML.fxml
    @Override
    public void start (Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("Content_FXML.fxml"));

        primaryStage.setTitle("FXML Playground");
        primaryStage.setScene(new Scene(root, 600, 275));
        primaryStage.show();
    }
}