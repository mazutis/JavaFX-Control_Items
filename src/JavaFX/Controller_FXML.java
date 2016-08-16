package JavaFX;

import javafx.scene.control.Button;

/**
 * Created by ernes on 14/08/2016.
 */
public class Controller_FXML {

    public Button buttonFXML;

    public void  ButtonClickMethod() {
        System.out.println("FXML Button has been clicked");
        buttonFXML.setText("Pressed");
    }
}
