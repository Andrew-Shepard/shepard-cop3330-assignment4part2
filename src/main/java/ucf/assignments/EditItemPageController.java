package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Shepard
 */

public class EditItemPageController implements Initializable {
    ObservableList<String> completionChoiceList = FXCollections.observableArrayList("Complete","Incomplete");
    @FXML private DatePicker itemDatePicker;
    @FXML private ChoiceBox<String> completionChoiceBox;
    @FXML private TextArea descriptionTextArea;
    @FXML private Label todoIndexLabel;
    User u = new User();
    void initData(User u) {
        this.u = u;
        itemDatePicker.setValue(u.getTodolist().get(u.active_item_index).getDue_date());
        descriptionTextArea.setText(u.getTodolist().get(u.active_item_index).getDescription());
        if(u.getTodolist().get(u.active_item_index).getCompletion_status() == false){
            completionChoiceBox.setValue("Incomplete");
        } else completionChoiceBox.setValue("Complete");
        todoIndexLabel.setText("["+u.active_item_index+"]");
    }
    public void SaveItem(ActionEvent actionEvent) {
        //take the information from the 3 fields on this button press
        u.getTodolist().get(u.active_item_index).setDue_date(itemDatePicker.getValue());
        u.getTodolist().get(u.active_item_index).setDescription(descriptionTextArea.getText());
        if(completionChoiceBox.getValue().equalsIgnoreCase("Complete")){
            u.getTodolist().get(u.active_item_index).setCompletion_status(Boolean.TRUE);
        } else u.getTodolist().get(u.active_item_index).setCompletion_status(Boolean.FALSE);
        //save the item to the passed index from todolistpagecontroller
    }

    public void ReturnToMainPage(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));

        MainPageController controller = loader.getController();
        controller.initData(u);

        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //sets up columns
        completionChoiceBox.setItems(completionChoiceList);
    }
}
