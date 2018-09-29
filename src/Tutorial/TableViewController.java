package Tutorial;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {

    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, LocalDate> birthdayColumn;
    @FXML private TextField firstNameTextField;
    @FXML private TextField lasttNameTextField;
    @FXML private DatePicker birthdayDatePicker;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Set up the columns in the table
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));

        //Set the table to be editable for the first and last names
        tableView.setEditable(true);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //This will allow the table to be able to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Load some dummy data
        tableView.setItems(getPeople());

    }

    //This method will return an ObservableList of Person objects
    private ObservableList<Person> getPeople() {

        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("Steven","Taylor",LocalDate.of(1966, Month.MAY, 30)));
        people.add(new Person("Frank","Sinatra",LocalDate.of(1915, Month.DECEMBER, 12)));
        people.add(new Person("Rebecca","Furgusson",LocalDate.of(1981, Month.JULY, 21)));

        return people;

    }

    //This method will delete the selected row(s)
    public void deleteButtonPressed()
    {
        ObservableList<Person> selectedRows, allPeople;
        allPeople = tableView.getItems();
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        allPeople.removeAll(selectedRows);
    }

    //This method will create a new Person Object and add it to the List
    public void newPersonButtonPressed()
    {
        Person person = new Person(firstNameTextField.getText(),
                                    lasttNameTextField.getText(),
                                    birthdayDatePicker.getValue());

        //Get all the items from the Table as a List and add our new Person to it
        tableView.getItems().add(person);
    }


    //This method will allow a person to double click on a cell and update the first name of the Person
    public void changeFirstName(TableColumn.CellEditEvent editedCell){

        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setFirstName(editedCell.getNewValue().toString());

    }

    //This method will allow a person to double click on a cell and update the last name of the Person
    public void changeLastName(TableColumn.CellEditEvent editedCell){

        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setLastName(editedCell.getNewValue().toString());

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
