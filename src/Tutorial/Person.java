package Tutorial;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private SimpleStringProperty firstName, lastName;
    private LocalDate birthday;
    private Image photo;

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public Person(String firstName, String lastName, LocalDate birthday) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.birthday = birthday;
        this.photo = new Image("file:Images/defaultUser.png");
    }

    public Person(String firstName, String lastName, LocalDate birthday, Image photo) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.birthday = birthday;
        this.photo = photo;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
        }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }


    public int getAge()
    {
        return Period.between(birthday,LocalDate.now()).getYears();
    }

    public Image getPhoto()
    {
        return photo;
    }
}
