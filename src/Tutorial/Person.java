package Tutorial;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Person {

    private SimpleStringProperty firstName, lastName;
    private LocalDate birthday;

    public Person(String firstName, String lastName, LocalDate birthday) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.birthday = birthday;
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


}
