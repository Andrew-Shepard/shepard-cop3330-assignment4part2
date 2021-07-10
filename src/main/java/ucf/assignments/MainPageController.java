package ucf.assignments;

import javafx.beans.Observable;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Shepard
 */
public class MainPageController implements Initializable {
    @FXML private TableView<Item> tableView;
    @FXML private TableColumn<Item, SimpleStringProperty> dueDateColumn;
    @FXML private TableColumn<Item, Boolean> completionStatusColumn;
    @FXML private TableColumn<Item, SimpleStringProperty> descriptionColumn;


    public ObservableList<Item> getItems(){
        ObservableList<Item> observable_list_items = FXCollections.observableArrayList();
        User u = new User("resources/Example.json");
        List<Item> list_items = u.loadItems();
        for(Item item : list_items){
            observable_list_items.add(item);
        }
        return observable_list_items;
    }
    public void EditTodolistItem(ActionEvent actionEvent) throws IOException {
        Parent listView = FXMLLoader.load(getClass().getResource("EditItemPage.fxml"));
        Scene listViewScene = new Scene(listView);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(listViewScene);
        window.show();
        //pass the current list of todolists to the edit item page's textboxs
        //using user.displayitems access each item in the todolist
        //put each part of the item into it's respective textbox
        //pass the index of this item to the next scene
    }

    public void DeleteTodolistItem(ActionEvent actionEvent) {
        //remove an item from a todolist arraylist using user.removeitem
        //update the list of todolists to not have that item within the todolist
    }

    public void AddTodolistItem(ActionEvent actionEvent) {
        //add an item to the todolist arraylist user.additem
        //update the list of todolists to include that new item
    }

    public void ReturnToMainPage(ActionEvent actionEvent) throws IOException {
        Parent listView = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene listViewScene = new Scene(listView);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(listViewScene);
        window.show();
        //pass the list of todolists to the main page
    }

    public void displayAllItems(ActionEvent actionEvent) {
        //get the new list of items using user.displayall
        //populate the relevant textboxes
    }

    public void displayCompleteItems(ActionEvent actionEvent) {
        //get the new list of items using user.displaycompleteitems
        //populate the relevant textboxes
    }

    public void displayIncompleteItems(ActionEvent actionEvent) {
        //get the new list of items using the user.displayincompleteitems
        //populate the relevant textboxes
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //sets up columns
        System.out.println(getItems());
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<Item,SimpleStringProperty>("due_date"));
        completionStatusColumn.setCellValueFactory(new PropertyValueFactory<Item,Boolean>("completion_status"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Item,SimpleStringProperty>("description"));
        //load data
        tableView.setItems(getItems());

    }
}
