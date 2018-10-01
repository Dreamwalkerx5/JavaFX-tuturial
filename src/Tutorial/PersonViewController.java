package Tutorial;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PersonViewController implements Initializable {

    @FXML private Label firstNameLabel;
    @FXML private Label lastNameLabel;
    @FXML private Label birthdayLabel;
    @FXML private Label ageLabel;
    @FXML private ImageView photo;

    private Person selectedPerson;
    private FileChooser fileChooser;
    private File filePath;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        System.out.println("PersonView created!");
    }

    public void initData(Person selectedPerson)
    {
        this.selectedPerson = selectedPerson;
        firstNameLabel.setText(selectedPerson.getFirstName());
        lastNameLabel.setText(selectedPerson.getLastName());
        birthdayLabel.setText(selectedPerson.getBirthday().toString());
        ageLabel.setText(Integer.toString(selectedPerson.getAge()));
        photo.setImage(selectedPerson.getPhoto());
    }

    //This method will allow the user to change the image on the screen
    public void chooseImageButtonPresssed(ActionEvent ev)
    {
        Stage stage = (Stage)((Node)ev.getSource()).getScene().getWindow();

        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image");

        //Set to user's directory or c:/ if we cannot access it
        String userDirectoryString = System.getProperty("user.home") + "\\Pictures";
        File userDirectory = new File(userDirectoryString);

        if(!userDirectory.canRead())
            userDirectory = new File("c:/");

        fileChooser.setInitialDirectory(userDirectory);

        this.filePath = fileChooser.showOpenDialog(stage);

        //Try to update the image with the user selected one
        try {
            BufferedImage bufferedImage = ImageIO.read(filePath);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            selectedPerson.setPhoto(image);
            photo.setImage(selectedPerson.getPhoto());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
