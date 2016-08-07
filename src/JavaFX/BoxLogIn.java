package JavaFX;

/**
 * Created by ernes on 10/07/2016.
 */

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BoxLogIn {
    static boolean result;

    public void loginInfo(){
        result = false;

    }

    public static boolean display (/*String user, String pass*/) {
        Stage window = new Stage();
        window.setTitle("Log In");
        window.initModality(Modality.APPLICATION_MODAL); //restrict other windows before this is dialog is over

        GridPane layout1 = new GridPane();
        layout1.setPadding(new Insets(10,10,10,10));
        layout1.setVgap(10);
        layout1.setHgap(5);

        Label lblWelcome = new Label("WELCOME");
        lblWelcome.setFont(Font.font ("Verdana", 16));
        layout1.setConstraints (lblWelcome, 0, 0);  //column  row

        Label lblName = new Label ("Username:");
        GridPane.setConstraints (lblName, 0, 2);

        TextField tfName = new TextField ("open");
        tfName.setPromptText("UserName");
        GridPane.setConstraints (tfName, 1, 2);

        Label lblPass = new Label ("Password:");
        GridPane.setConstraints (lblPass, 0, 3);

        TextField tfPass = new TextField ("open");
        tfPass.setPromptText("Password");
        GridPane.setConstraints (tfPass, 1, 3);

        Button btnLogIn = new Button ("Log In");
        GridPane.setConstraints(btnLogIn, 1,4);
        btnLogIn.setOnAction(e -> {
            String InputUser = tfName.getText();
            String InputPass = tfPass.getText();
            if (InputUser.equals("open") && InputPass.equals("open")){
                result = true;
                System.out.println ("Log-In Successful");
                window.close();
            } else {
                System.out.println ("Log-In failure");
                window.close();
            }
        });

        layout1.getChildren().addAll(lblWelcome, lblName, lblPass, tfName, tfPass, btnLogIn);

        Scene scene = new Scene(layout1, 280, 180);
        scene.getStylesheets().add("JavaFX/GUI00.css");
        //window.getIcons().add(new Image("JavaFX/32x32FavIcon.jpg"));//Classes folder of JavaFX Project
        window.setScene(scene);
        window.showAndWait();

        return result;
    }
}
