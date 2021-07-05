package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EditTodoListPageController {
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
}
