package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by ernes on 29/07/2016.
 */
public class BoxControl_Items{
    public void display () {
        Stage window = new Stage();
        window.setTitle("Various Control Items");
        window.setMinWidth(250);
        System.out.println ("Control Items Box activated");

        Label lblComboCheck = new Label ("Check and Combo boxes: ");
        //Choice box innactive
        ChoiceBox<String> choiceBox01 = new ChoiceBox<>();
        choiceBox01.getItems().addAll("Choice01", "Choice02", "Choice03", "Choice04", "Choice05");
        choiceBox01.setValue("Choice01");
        choiceBox01.setMinWidth(200);

        //Check boxes
        CheckBox check01 = new CheckBox("CheckBox 01");
        CheckBox check02 = new CheckBox("CheckBox 02");
        CheckBox check03 = new CheckBox("CheckBox 03");
        CheckBox check04 = new CheckBox("CheckBox 04");
        CheckBox check05 = new CheckBox("CheckBox 05");

        //Label
        Label lblSpace01 = new Label(" \n        ");

        //Choice Box active
        ChoiceBox<Integer> choiceBox02 = new ChoiceBox<>();
        choiceBox02.getItems().addAll(1, 2, 3, 4, 5);
        choiceBox02.setValue(1);
        choiceBox02.setMinWidth(200);
        choiceBox02.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->
                System.out.println("ChoiceBox: " +newValue));

        Label lblChoice02 = new Label("System is listening this choicebox \n ");

        //ComboBox
        ComboBox<String> comboBox01 = new ComboBox<>();
        comboBox01.getItems().addAll("High", "Medium", "Low");
        comboBox01.setPromptText("ComboBox01 with 3 choices: ");
        comboBox01.setMinWidth(200);
        comboBox01.setOnAction ( e-> System.out.println("ComboBox01 action, selected: " + comboBox01.getValue()));

        ComboBox<Integer> comboBox02 = new ComboBox<>();
        comboBox02.getItems().addAll( 2016, 2007, 1989, 1976);
        comboBox02.setPromptText ("ComboBox02. Chooce or enter the year: ");
        comboBox02.setMinWidth(200);
        comboBox02.setEditable(true);
        comboBox02.setOnAction ( e-> System.out.println("ComboBox02 action, selected: " + comboBox02.getValue()));

        //Btn01
        Button btnConfirm01 = new Button ("Confirm check/combo boxes ");
        btnConfirm01.setOnAction ( e -> {
            getChoice (choiceBox01, choiceBox02);
            handleOptions (check01, check02, check03, check04, check05);
            comboAction(comboBox01, comboBox02);
            System.out.println();
        });

        Label lblListView = new Label ("List View: ");
        //ListView
        ListView<String> listView = new ListView<>();
        listView.setMaxHeight(150);
        listView.getItems().addAll("ListView Item 01", "ListView Item 02", "ListView Item 03", "ListView Item 04",
                "ListView Item 05", "ListView Item 06", "ListView Item 07", "ListView Item 08", "ListView Item 09",
                "ListView Item 10", "ListView Item 11", "ListView Item 12", "ListView Item 13", "ListView Item 14" );
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Label lblTreeView = new Label ("Tree View: ");
        //TreeView
        TreeView<String> tree;
        TreeItem<String> root, Sub01, Sub02, Sub03;
            //Root
            root = new TreeItem<>();
            root.setExpanded(true);
                //Sub01
                Sub01 = makeTreeBranche ("SubFolder01", root);
                makeTreeBranche("Tree Item 01 01", Sub01);
                makeTreeBranche("Tree Item 01 02", Sub01);
                makeTreeBranche("Tree Item 01 03", Sub01);
                makeTreeBranche("Tree Item 01 04", Sub01);
                makeTreeBranche("Tree Item 01 05", Sub01);
                //Sub02
                Sub02 = makeTreeBranche ("SubFolder02", root);
                makeTreeBranche("Tree Item 02 01", Sub02);
                makeTreeBranche("Tree Item 02 02", Sub02);
                makeTreeBranche("Tree Item 02 03", Sub02);
                makeTreeBranche("Tree Item 02 04", Sub02);
                makeTreeBranche("Tree Item 02 05", Sub02);
                //Sub03
                Sub03 = makeTreeBranche ("SubFolder03", root);
                makeTreeBranche("Tree Item 03 01", Sub03);
                makeTreeBranche("Tree Item 03 02", Sub03);
                makeTreeBranche("Tree Item 03 03", Sub03);
                makeTreeBranche("Tree Item 03 04", Sub03);
                makeTreeBranche("Tree Item 03 05", Sub03);
                //Sub04 Branch without method
                TreeItem<String> Sub04 = new TreeItem<>("Sub04");
                Sub04.setExpanded(true);
                root.getChildren().add(Sub04);
                TreeItem<String> Sub0401 = new TreeItem<>("Tree Item 04 01");
                TreeItem<String> Sub0402 = new TreeItem<>("Tree Item 04 02");
                TreeItem<String> Sub0403 = new TreeItem<>("Tree Item 04 03");
                TreeItem<String> Sub0404 = new TreeItem<>("Tree Item 04 04");
                TreeItem<String> Sub0405 = new TreeItem<>("Tree Item 04 05");
                Sub04.getChildren().addAll(Sub0401, Sub0402, Sub0403, Sub0404, Sub0405);
            //Create Tree
            tree = new TreeView<>(root);
            tree.setMinWidth(150);
            tree.setShowRoot(false);

        //Btn02
        Button btnConfirm02 = new Button ("Confirm List");
        btnConfirm02.setOnAction ( e-> {
            ListViewAction(listView);
        });

        //TableView
        TableView<SpreadSheet> TableView01 = new TableView<>();
            //IdColumn
            TableColumn<SpreadSheet, String> idColumn = new TableColumn ("ID");
            idColumn.setMinWidth(50);
            idColumn.setCellValueFactory(new PropertyValueFactory("id"));
            //FirstNameColumn
            TableColumn<SpreadSheet, String> FirstNameColumn = new TableColumn ("First Name");
            FirstNameColumn.setMinWidth(150);
            FirstNameColumn.setCellValueFactory(new PropertyValueFactory("FirstName"));
            //LastNameColumn
            TableColumn<SpreadSheet, String> LastNameColumn = new TableColumn ("Last Name");
            LastNameColumn.setMinWidth(150);
            LastNameColumn.setCellValueFactory(new PropertyValueFactory("LastName"));
            //AgeColumn
            TableColumn<SpreadSheet, String> AgeColumn = new TableColumn ("Age");
            AgeColumn.setMinWidth(50);
            AgeColumn.setCellValueFactory(new PropertyValueFactory("age"));
            //ScoreColumn
            TableColumn<SpreadSheet, String> ScoreColumn = new TableColumn ("Score");
            ScoreColumn.setMinWidth(50);
            ScoreColumn.setCellValueFactory(new PropertyValueFactory("score"));
        TableView01.setItems(getSpreadSheet());
        TableView01.getColumns().addAll(idColumn, FirstNameColumn,LastNameColumn,AgeColumn,ScoreColumn);

        //Input
        TextField InputId = new TextField();
        InputId.setPromptText("Id");
        InputId.setPrefWidth(30);
        TextField InputFirstName = new TextField();
        InputFirstName.setPromptText("First Name");
        InputFirstName.setPrefWidth(80);
        TextField InputLastName = new TextField();
        InputLastName.setPromptText("Last Name");
        InputLastName.setPrefWidth(80);
        TextField InputAge = new TextField();
        InputAge.setPromptText("Age");
        InputAge.setPrefWidth(35);
        TextField InputScore = new TextField();
        InputScore.setPromptText("Score");
        InputScore.setPrefWidth(50);

        Button btnAdd = new Button("Add");
        btnAdd.setMinWidth(50);
        btnAdd.setOnAction( e-> {
            SpreadSheet SpreadSheet = new SpreadSheet();
            SpreadSheet.setId(Integer.parseInt(InputId.getText()));
            SpreadSheet.setFirstName(InputFirstName.getText());
            SpreadSheet.setLastName(InputLastName.getText());
            SpreadSheet.setAge(Integer.parseInt(InputAge.getText()));
            SpreadSheet.setScore(Double.parseDouble(InputScore.getText()));
            TableView01.getItems().add(SpreadSheet);
            InputId.clear();
            InputFirstName.clear();
            InputLastName.clear();
            InputAge.clear();
            InputScore.clear();
        });

        Button btnDelete = new Button("Delete");
        btnDelete.setMinWidth(60);
        btnDelete.setOnAction ( e-> {
            ObservableList<SpreadSheet> Selected, AllEmployees;
            AllEmployees = TableView01.getItems();
            Selected = TableView01.getSelectionModel().getSelectedItems();
            Selected.forEach(AllEmployees::remove);
        });

        VBox layout01 = new VBox(5);
        layout01.setPadding(new Insets(10,10,10,10));
        layout01.getChildren().addAll(lblComboCheck, choiceBox01, check01, check02, check03, check04, check05, choiceBox02,
                                      lblChoice02, comboBox01, comboBox02,lblSpace01, btnConfirm01 );

        VBox layout02 = new VBox(5);
        layout02.setPadding(new Insets(10,10,10,10));
        layout02.getChildren().addAll(lblListView, listView, btnConfirm02, lblTreeView, tree);

        HBox layout0302 = new HBox ();
        layout0302.getChildren().addAll(InputId,InputFirstName,InputLastName,InputAge,InputScore,btnAdd,btnDelete);
        VBox layout03 = new VBox(5);
        layout03.setPadding(new Insets(10,10,10,10));
        layout03.getChildren().addAll(TableView01,layout0302);

        HBox layout00 = new HBox();
        layout00.getChildren().addAll(layout01, layout02, layout03);

        Scene scene = new Scene(layout00, 800, 550);
        window.setScene(scene);
        window.showAndWait();
    }

    private static void handleOptions (CheckBox check01, CheckBox check02, CheckBox check03, CheckBox check04,
                                       CheckBox check05) {
        String message = "CheckBox: ";
        if (check01.isSelected())
            message += " Check01, ";
        if (check02.isSelected())
            message += " Check02, ";
        if (check03.isSelected())
            message += " Check03, ";
        if (check04.isSelected())
            message += " Check04, ";
        if (check05.isSelected())
            message += " Check05, ";
        System.out.println(message);
    }

    private void getChoice (ChoiceBox<String> choiceBox01, ChoiceBox<Integer> choiceBox02){
        String choiceMade01 = choiceBox01.getValue();
        int choiceMade02 = choiceBox02.getValue();
        System.out.println("ChoiceBox01: " + choiceMade01);
        System.out.println("ChoiceBox02: " + choiceMade02);
    }

    private void comboAction(ComboBox<String> comboBox01, ComboBox<Integer> comboBox02 ) { //Passing the value : "(ComboBox<String> comboBox)"
        System.out.println("ComboBox01: " +comboBox01.getValue());
        System.out.println("ComboBox02: " +comboBox02.getValue());
    }

    private void ListViewAction (ListView<String> listView) {
        String message = "";
        ObservableList<String> YourItems;                             //ObservableList object for storing selected Items
        YourItems = listView.getSelectionModel().getSelectedItems();
        for  (String m : YourItems) {                                 //m indentifier of array
            message += m + "\n";
        }
        System.out.println("Selected Items: \n" +message);
    }

    //TreeView making branche method
    private TreeItem<String> makeTreeBranche (String Title, TreeItem<String> parent) {
        TreeItem<String> Item = new TreeItem<>(Title);
        Item.setExpanded(true);
        parent.getChildren().add(Item);
        return Item;
    }

    //Creating the data list for TableView
    public ObservableList<SpreadSheet> getSpreadSheet(){
        ObservableList<SpreadSheet> NewEmployees = FXCollections.observableArrayList();
        NewEmployees.add(new SpreadSheet(01, "FirstNameAA", "LastNameAA", 25, 1.2));
        NewEmployees.add(new SpreadSheet(02, "FirstNameBB", "LastNameBB", 18, 1.0));
        NewEmployees.add(new SpreadSheet(03, "FirstNameCC", "LastNameCC", 35, 2.6));
        NewEmployees.add(new SpreadSheet(04, "FirstNameDD", "LastNameDD", 78, 3.1));
        NewEmployees.add(new SpreadSheet(05, "FirstNameEE", "LastNameEE", 23, 8.6));
        return NewEmployees;
    }

}
