package Tutorial;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    //These items are for the CheckBox
    @FXML private Label pizzaToppingsLabel;
    @FXML private CheckBox pepperoniCheckbox;
    @FXML private CheckBox pineappleCheckbox;
    @FXML private CheckBox baconCheckbox;

    //These items are for the ChoiceBox
    @FXML private ChoiceBox<String> choiceBox;
    @FXML private Label choiceBoxLabel;

    //These items are for the ComboBox
    @FXML private ComboBox<String> comboBox;
    @FXML private Label comboBoxLabel;

    //These items are for the radio buttons
    @FXML private Label radioButtonsLabel;
    @FXML private RadioButton phpRadioButton;
    @FXML private RadioButton javaRadioButton;
    @FXML private RadioButton cPlusPlusRadioButton;
    @FXML private RadioButton cSharpRadioButton;
    private ToggleGroup favLanguageToggleGroup;

    //These items are for the ListView and TextArea examples
    @FXML private ListView<String> listView;
    @FXML private TextArea golfTextArea;

    //These items are for the gradeSpinner
    @FXML private Spinner<Integer> gradeSpinner;
    @FXML private Label gradeLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pizzaToppingsLabel.setText("");

        //These items are for the ChoiceBox
        choiceBoxLabel.setText("");
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().add("Bananas");
        choiceBox.getItems().addAll("Oranges","Pears","Strawberries");
        choiceBox.setValue("Apples");

        //These items are for the ComboBox
        comboBox.getItems().add("COMP1030");
        comboBox.getItems().addAll("COMP1008","MGMT2003","MGMT2010");
        comboBoxLabel.setText("");

        //These items are for the radio buttons
        radioButtonsLabel.setText("");
        favLanguageToggleGroup = new ToggleGroup();
        phpRadioButton.setToggleGroup(favLanguageToggleGroup);
        javaRadioButton.setToggleGroup(favLanguageToggleGroup);
        cPlusPlusRadioButton.setToggleGroup(favLanguageToggleGroup);
        cSharpRadioButton.setToggleGroup(favLanguageToggleGroup);

        //These items are for the ListView and TextArea examples
        listView.getItems().addAll("Golf balls","Wedges","Irons","Tees","Driver","Putter");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Configure the gradeSpinner with the values 1-100
        SpinnerValueFactory<Integer> gradesValueFactory =  new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 75);
        gradeSpinner.setValueFactory(gradesValueFactory);
        gradeLabel.setVisible(false);
    }

    //This method will read from the grade Spinner and update the Label
    public void getGradeButtonPressed()
    {
        gradeLabel.setText(gradeSpinner.getValue().toString());
        gradeLabel.setVisible(true);
    }

    public void changeSceneButtonPressed(ActionEvent ev) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TableView.fxml"));
        Scene tableVScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)ev.getSource()).getScene().getWindow();

        window.setScene(tableVScene);
        window.show();

    }

    public void listViewButtonPressed(){
        String textAreaString = "";

        ObservableList<String> listOfItems = listView.getSelectionModel().getSelectedItems();
        for(Object item : listOfItems){
            textAreaString += String.format("%s%n",(String)item);
        }

        golfTextArea.setText(textAreaString);
    }

    public void radioButtonChanged(){
        if(favLanguageToggleGroup.getSelectedToggle().equals(phpRadioButton))
            radioButtonsLabel.setText("The selected item is: PHP");
        if(favLanguageToggleGroup.getSelectedToggle().equals(javaRadioButton))
            radioButtonsLabel.setText("The selected item is: Java");
        if(favLanguageToggleGroup.getSelectedToggle().equals(cPlusPlusRadioButton))
            radioButtonsLabel.setText("The selected item is: C++");
        if(favLanguageToggleGroup.getSelectedToggle().equals(cSharpRadioButton))
            radioButtonsLabel.setText("The selected item is: C#");
    }

    public void comboBoxWasUpdated(){
        comboBoxLabel.setText("Course selected:\n" + comboBox.getValue());
    }

    public void choiceBoxButtonPressed(){
        choiceBoxLabel.setText("My favourite fruit is\n" + choiceBox.getValue());
    }

    public void pizzaOrderButtonPressed(){
        String order = "Toppings are:";

        if(pepperoniCheckbox.isSelected())
            order += "\nPeperoni";
        if(pineappleCheckbox.isSelected())
            order += "\nPineapple";
        if(baconCheckbox.isSelected())
            order += "\nBacon";

        pizzaToppingsLabel.setText(order);
    }


}
