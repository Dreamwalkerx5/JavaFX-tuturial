package Tutorial;

import Tutorial.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PersonViewController implements Initializable {

    @FXML private Label firstNameLabel;
    @FXML private Label lastNameLabel;
    @FXML private Label birthdayLabel;
    @FXML private Label ageLabel;

    private Person selectedPerson;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    public void initData(Person selectedPerson)
    {
        this.selectedPerson = selectedPerson;
        firstNameLabel.setText(selectedPerson.getFirstName());
        lastNameLabel.setText(selectedPerson.getLastName());
        birthdayLabel.setText(selectedPerson.getBirthday().toString());
        ageLabel.setText(Integer.toString(selectedPerson.getAge()));
    }

    public void changeSceneButtonPressed(ActionEvent ev) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TableView.fxml"));
        Scene tableVScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)ev.getSource()).getScene().getWindow();

        window.setScene(tableVScene);
        window.show();

    }
}
