package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    ArrayList<Patient> patients = new ArrayList<>();
    ObservableList choiceList = FXCollections.observableArrayList();

    public void dataSort() {
        choiceList.removeAll(choiceList);
        String names = "Imienia";
        String lastNames = "Nazwiska";
        String ages = "Wieku";
        String id = "Kolejności dodania";
        choiceList.addAll(names, lastNames, ages, id);
        choice.getItems().addAll(choiceList);
    }

    public void sortByNames() {
        patients.sort(Comparator.comparing(Patient::getName));
        for(int i = 0; i < patients.size(); i++) {
            System.out.println("{\n\t\"imie\": \"" + patients.get(i).getName() + "\",\n\t\"nazwisko\": \"" +
                    patients.get(i).getLastName() + "\",\n\t\"wiek\": \"" + patients.get(i).getAge() + "\"\n}");
        }
    }

    public void sortByLastName() {
        patients.sort(Comparator.comparing(Patient::getLastName));
        for(int i = 0; i < patients.size(); i++) {
            System.out.println("{\n\t\"imie\": \"" + patients.get(i).getName() + "\",\n\t\"nazwisko\": \"" +
                    patients.get(i).getLastName() + "\",\n\t\"wiek\": \"" + patients.get(i).getAge() + "\"\n}");
        }
    }

    public void sortByAges() {
        patients.sort(Comparator.comparing(Patient::getAge));
        for(int i = 0; i < patients.size(); i++) {
            System.out.println("{\n\t\"imie\": \"" + patients.get(i).getName() + "\",\n\t\"nazwisko\": \"" +
                    patients.get(i).getLastName() + "\",\n\t\"wiek\": \"" + patients.get(i).getAge() + "\"\n}");
        }
    }

    public void sortById() {
        for (Patient patient : patients) {
            System.out.println("{\n\t\"imie\": \"" + patient.getName() + "\",\n\t\"nazwisko\": \"" +
                    patient.getLastName() + "\",\n\t\"wiek\": \"" + patient.getAge() + "\"\n}");
         }
    }

    @FXML
    private TextField name;

    @FXML
    private TextField lastName;

    @FXML
    private TextField age;

    @FXML
    private Button addToCollection;

    @FXML
    private Button print;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    void addToCollection(ActionEvent event) {
        try {
            patients.add(new Patient(name.getText(), lastName.getText(), Integer.parseInt(age.getText())));
        } catch (Exception e) {

        }
    }

    @FXML
    void print(ActionEvent event) {
        try {
            String value = (String) choice.getValue();
            if (value == "Imienia") {
                sortByNames();
            } else if (value == "Nazwiska") {
                sortByLastName();
            } else if (value == "Wieku") {
                sortByAges();
            } else {
                sortById();
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataSort();
    }
}
