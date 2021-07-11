package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Shepard
 */

public class EditItemPageController implements Initializable {
    @FXML private DatePicker itemDatePicker;
    @FXML private ChoiceBox<Boolean> completionChoiceBox;
    @FXML private TextArea descriptionTextArea;

    public void SaveItem(ActionEvent actionEvent) {
        //take the information from the 3 fields on this button press
        //save the item to the passed index from todolistpagecontroller
    }

    public void ReturnToMainPage(ActionEvent actionEvent) throws IOException {
        Parent listView = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene listViewScene = new Scene(listView);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(listViewScene);
        window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //sets up columns
        //itemDatePicker.setValue();

    }
}
