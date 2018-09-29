package Tutorial;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void changeSceneButtonPressed(ActionEvent ev) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        Scene tableVScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)ev.getSource()).getScene().getWindow();

        window.setScene(tableVScene);
        window.show();

    }
}
