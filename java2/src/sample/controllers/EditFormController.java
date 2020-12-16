package sample.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.Main;
import sample.models.Person;
import sample.utils.DateUtil;

public class EditFormController {

    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField birthdayTextField;
    @FXML
    private TextField streetTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private TextField postalCodeTextField;

    private Main main;
    private Person person;

    public EditFormController(){}

    @FXML
    private void initialize(){
    }

    public void setMainApp(Main main){
        this.main = main;
    }

    public void setPerson(Person person){
        this.person = person;
        showPersonalDetails(person);
    }

    private void showPersonalDetails(Person person){
        if (person != null){
            firstNameTextField.setText(person.getFirstName());
            lastNameTextField.setText(person.getLastName());
            streetTextField.setText(person.getStreet());
            cityTextField.setText(person.getCity());
            postalCodeTextField.setText(Integer.toString(person.getPostalCode()));
            birthdayTextField.setText(DateUtil.format(person.getBirthday()));
        }
        else {
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            streetTextField.setText("");
            cityTextField.setText("");
            postalCodeTextField.setText("");
            birthdayTextField.setText("");
        }
    }

    @FXML
    private void handleBack(){
        main.showPersonOnView();
    }

    @FXML
    private void handleApplyChanges() {
        if (firstNameTextField.getText().equals("") || lastNameTextField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No input");
            alert.setHeaderText("No Person Name");
            alert.setContentText("Please write person name");
            alert.showAndWait();
        } else if (!DateUtil.validDate(birthdayTextField.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("Wrong date");
            alert.setHeaderText("Wrong Birthday Date");
            alert.setContentText("Please write person birthday in format dd.mm.yyyy");
            alert.showAndWait();
        } else {
            if (person == null) {
                person = new Person();
                ObservableList<Person> personData = main.getPersonData();
                personData.add(person);
                main.setPersonData(personData);
            }
            person.setFirstName(firstNameTextField.getText());
            person.setLastName(lastNameTextField.getText());
            person.setCity(cityTextField.getText());
            person.setStreet(streetTextField.getText());
            try {
                person.setPostalCode(Integer.parseInt(postalCodeTextField.getText()));
                person.setBirthday(DateUtil.parse(birthdayTextField.getText()));
                main.showPersonOnView();
            }catch (NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(main.getPrimaryStage());
                alert.setTitle("Wrong postal code");
                alert.setHeaderText("Wrong Postal Code");
                alert.setContentText("Please write person postal code in numbers");
                alert.showAndWait();
            }

        }

    }

}
