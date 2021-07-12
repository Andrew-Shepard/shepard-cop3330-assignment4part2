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
import javafx.scene.control.TextField;
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
    @FXML private TableColumn<Item, LocalDate> dueDateColumn;
    @FXML private TableColumn<Item, Boolean> completionStatusColumn;
    @FXML private TableColumn<Item, SimpleStringProperty> descriptionColumn;
    @FXML private TextField filenameTextbox;

    private User u = new User();
    void initData(User u){
        this.u = u;
        tableView.setItems(u.getAllItems());
    }
    public ObservableList<Item> getItems(){
        ObservableList<Item> observable_list_items = FXCollections.observableArrayList();
        List<Item> list_items = u.loadItems();
        for(Item item : list_items){
            observable_list_items.add(item);
        }
        return observable_list_items;
    }
    public void EditTodolistItem(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditItemPage.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));

        EditItemPageController controller = loader.getController();
        ObservableList<Item> item;
        item = tableView.getSelectionModel().getSelectedItems();
        //Set the active item to be accessed in the next scene
        u.setActive_item_index(u.findItem_index(item.get(0)));
        controller.initData(u);

        stage.show();



    }

    public void DeleteTodolistItem(ActionEvent actionEvent) {
        //remove an item from a todolist arraylist using user.removeitem
        ObservableList<Item> item;
        item = tableView.getSelectionModel().getSelectedItems();
        u.removeItem(item.get(0));
        //update the list of todolists to not have that item within the todolist
        tableView.setItems(u.getAllItems());
    }

    public void AddTodolistItem(ActionEvent actionEvent) {
        //add an item to the todolist arraylist user.additem
        u.addItem("New Item Description",false,LocalDate.now());
        //update the list of todolists to include that new item
        tableView.setItems(u.getAllItems());
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
        tableView.setItems(u.getAllItems());
        //populate the relevant textboxes
    }

    public void displayCompleteItems(ActionEvent actionEvent) {
        //get the new list of items using user.displaycompleteitems
        tableView.setItems(u.getCompleteItems());
        //populate the relevant textboxes
    }

    public void displayIncompleteItems(ActionEvent actionEvent) {
        //get the new list of items using the user.displayincompleteitems
        tableView.setItems(u.getIncompleteItems());
        //populate the relevant textboxes
    }
    public void loadTodolist(ActionEvent actionEvent) {
        //load new json
        //set user's list to the list the data in that json
        u.setFilePath(filenameTextbox.getText());
        u.setTodolist(getItems());
        //update display
        tableView.setItems(u.getAllItems());
    }
    public void saveTodolist(ActionEvent actionEvent) {
        u.setFilePath(filenameTextbox.getText());
        System.out.println(filenameTextbox.getText());
        u.saveTodoLists();
    }
    public void clearTodoList(ActionEvent actionEvent) {
        u.clearTodoList();
        //update display
        tableView.setItems(u.getAllItems());
    }
    public void sortByDate(ActionEvent actionEvent) {
        u.sortItemByDate();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //sets up columns
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<Item,LocalDate>("due_date"));
        completionStatusColumn.setCellValueFactory(new PropertyValueFactory<Item,Boolean>("completion_status"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Item,SimpleStringProperty>("description"));
        //load data
    }
}
