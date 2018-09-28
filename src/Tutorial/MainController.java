package Tutorial;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    //These items are for the CheckBox
    @FXML private Label pizzaToppingsLabel;
    @FXML private CheckBox pepperoniCheckbox;
    @FXML private CheckBox pineappleCheckbox;
    @FXML private CheckBox baconCheckbox;

    //These items are for the ChoiceBox
    @FXML private ChoiceBox choiceBox;
    @FXML private Label choiceBoxLabel;

    //These items are for the ComboBox
    @FXML private ComboBox comboBox;
    @FXML private Label comboBoxLabel;


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
    }

    public void comboBoxWasUpdated(){
        comboBoxLabel.setText("Course selected:\n" + comboBox.getValue().toString());
    }

    public void choiceBoxButtonPressed(){
        choiceBoxLabel.setText("My favourite fruit is\n" + choiceBox.getValue().toString());
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
