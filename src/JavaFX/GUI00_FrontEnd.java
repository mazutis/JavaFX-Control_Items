package JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.Scanner;

/**
 * Created by ernes on 04/07/2016.
 */

//Related to ClassB and ClassC
public class GUI00_FrontEnd extends Application {

    public static void main (String args[]) {launch (args);}
    Stage stage = new Stage();
    Scene scene;
    BorderPane layoutMain;
    GridPane layoutCenter1;
    VBox   layoutCenterMethods, layoutCenterConstructors, layoutCenterControlItems, layoutCenterAbout, layoutCenterHelp;
    MenuBar menuBar;
    Button  btnExit;
    Label  lblSpace, lblExit;


    public void start (Stage primaryStage) throws Exception {

        //File Menu
        Menu mainMenu = new Menu("File");
        MenuItem miNew = new MenuItem("New");
        miNew.setOnAction (e-> {
            layoutMain.setCenter(layoutCenter1);
            System.out.println("Menu Item New has been choosen");
        });
        mainMenu.getItems().add(miNew);

        MenuItem miOpen = new MenuItem("Open...");
        miOpen.setDisable(true);
        mainMenu.getItems().add(miOpen);

        mainMenu.getItems().add(new SeparatorMenuItem());
        MenuItem miExit = new MenuItem("Exit");
        miExit.setOnAction(e->{
            closeScene();
        });
        mainMenu.getItems().add(miExit);

        //Methods Menu
        Menu methodsMenu = new Menu ("_Methods");

        MenuItem miMethods = new MenuItem("Methods");
        miMethods.setOnAction (e-> {
            layoutMain.setCenter(layoutCenterMethods);
            System.out.println("Menu Item Methods has been choosen");
        });

        MenuItem miConstructors = new MenuItem("Constructors");
        miConstructors.setOnAction (e-> {
            layoutMain.setCenter(layoutCenterConstructors);
            System.out.println("Menu Item Constructors has been choosen");
        });

        MenuItem miMethod03 = new MenuItem("Method 03 (no action)");
        miMethod03.setDisable(true);

        MenuItem miMethod04 = new MenuItem("Method 04 (no action)");
        miMethod04.setDisable(true);

        methodsMenu.getItems().addAll(miMethods, miConstructors, miMethod03, miMethod04);

        //JavaFX Menu
        Menu javaFXMenu = new Menu("_JavaFX");

        MenuItem miRandomNumber = new MenuItem("Random Number...");
        miRandomNumber.setOnAction ( e-> {
            BoxRandomNumber rb = new BoxRandomNumber();
            int result = rb.display();
            System.out.println("Number received from random box: " + result);
        } );

        MenuItem miControlItems = new MenuItem("Various Control Items");
        miControlItems.setOnAction (e -> {
            layoutMain.setCenter(layoutCenterControlItems);
        });
        javaFXMenu.getItems().add(miRandomNumber);
        javaFXMenu.getItems().add(new SeparatorMenuItem());
        javaFXMenu.getItems().add(miControlItems);


        //Options Menu
        Menu optionsMenu = new Menu("_Options");
        CheckMenuItem optionAMenuItem = new CheckMenuItem("Check Option A (no action)");
        optionsMenu.getItems().add(optionAMenuItem);
        optionAMenuItem.setOnAction ( e-> {
            if (optionAMenuItem.isSelected()){
                System.out.println("Option A = true");
            }
            else {
                System.out.println("Option A = false");
            }
        });

        CheckMenuItem optionBMenuItem = new CheckMenuItem("Check Option B (no action)");
        optionsMenu.getItems().add(optionBMenuItem);
        optionBMenuItem.setSelected(true);
        optionBMenuItem.setOnAction ( e-> {
            if (optionBMenuItem.isSelected()){
                System.out.println("Option B = true");
            }
            else {
                System.out.println("Option B = false");
            }
        });
        optionsMenu.getItems().add(new SeparatorMenuItem());

        ToggleGroup ABC = new ToggleGroup();
        RadioMenuItem aRadioMenuItem = new RadioMenuItem("A of ABC (no action)");
        RadioMenuItem bRadioMenuItem = new RadioMenuItem("B of ABC (no action)");
        RadioMenuItem cRadioMenuItem = new RadioMenuItem("C of ABC (no action)");
        aRadioMenuItem.setToggleGroup(ABC);
        bRadioMenuItem.setToggleGroup(ABC);
        cRadioMenuItem.setToggleGroup(ABC);
        optionsMenu.getItems().addAll(aRadioMenuItem, bRadioMenuItem, cRadioMenuItem);
        aRadioMenuItem.setSelected(true);

        //Help Menu
        Menu helpMenu = new Menu("_Help");
        MenuItem aboutMenuItem = new MenuItem ("About");
        aboutMenuItem.setOnAction ( e-> {
            System.out.println("Menu Item About has been choosen");
            layoutMain.setCenter(layoutCenterAbout);
        });
        aboutMenuItem.setDisable(true);

        MenuItem helpMenuItem = new MenuItem ("Help");
        helpMenuItem.setOnAction (e-> {
            layoutMain.setCenter(layoutCenterHelp);
            System.out.println("Menu Item Help has been choosen");
        });
        helpMenuItem.setDisable(true);

        helpMenu.getItems().add(aboutMenuItem);
        helpMenu.getItems().add(new SeparatorMenuItem());
        helpMenu.getItems().add(helpMenuItem);

        //Menu Bar
        menuBar = new MenuBar();
        menuBar.getMenus().addAll(mainMenu, methodsMenu, javaFXMenu, optionsMenu, helpMenu);
        menuBar.setPadding (new Insets(0,0,0,0));

        lblSpace = new Label("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n               ");

        /*btnExit = new Button ("Exit");
        btnExit.setMinWidth(150);
        lblExit  = new Label ("Exit program confirmation \n ");
        btnExit.setOnAction (e-> {
            closeScene();
        });*/

        Label lblTop = new Label();
        lblTop.setText("Just because you feel good ");
        lblTop.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        //Layout Center1
        VBox layoutCenter01 = new VBox();
        layoutCenter01.getChildren().addAll(lblSpace/*, btnExit, lblExit*/);
        layoutCenter1 = new GridPane ();
        layoutCenter1.setHgap(10);
        layoutCenter1.setVgap(10);
        layoutCenter1.setPadding(new Insets(10,10,10,10));
        layoutCenter1.getChildren().addAll(lblTop,layoutCenter01);
        layoutCenter1.setConstraints(lblTop, 1, 0); // column, row
        layoutCenter1.setConstraints(layoutCenter01, 1, 1); // column, row

        //Layout CenterMethods
        layoutCenterMethods = new VBox();
        Content_Methods contentMethods = new Content_Methods();
        contentMethods.methods (layoutCenterMethods);

        //Layout CenterConstructors
        layoutCenterConstructors = new VBox();
        Content_Constructor contentConstructor = new Content_Constructor();
        contentConstructor.constructor (layoutCenterConstructors);

        //Layout CenterControlItems
        layoutCenterControlItems = new VBox();
        Content_VariousControlItems controlItems = new Content_VariousControlItems();
        controlItems.controlItems(layoutCenterControlItems);

        //Layout LayoutCenterAbout
        layoutCenterAbout = new VBox();
        Content_About contentAbout = new Content_About();
        contentAbout.about(layoutCenterAbout);

        //Layout LayoutCenterHelp
        layoutCenterHelp = new VBox();
        Content_Help contentHelp = new Content_Help();
        contentHelp.help (layoutCenterHelp);

        layoutMain = new BorderPane();
        layoutMain.setTop(menuBar);
        layoutMain.setCenter(layoutCenter1); //layoutCenterControlItems
        scene = new Scene (layoutMain, 800, 600);
        scene.getStylesheets().add("JavaFX/GUI00.css");

        stage.setTitle ("Playground");
        //stage.getIcons().add(new Image("JavaFX/32x32FavIcon.jpg"));//Classes folder of JavaFX Project
        stage.setOnCloseRequest(e -> {
            e.consume();
            closeScene();
        });
        stage.setMinWidth(1000);
        stage.setMinHeight(1200);
        stage.setScene(scene);
        stage.show();

        //LOG-IN
        boolean LogInfo = BoxLogIn.display();
        if (LogInfo == false) {
            System.out.println("Closing program...");
            stage.close();
        }
        else  {
            layoutMain.setCenter(layoutCenterControlItems);
        }

    }
    private void closeScene(){
        boolean answer = BoxConfirm.display("   Exit   ", "  Do you really want to exit?  ");
        if(answer) {
            stage.close();
        }
    }

}
