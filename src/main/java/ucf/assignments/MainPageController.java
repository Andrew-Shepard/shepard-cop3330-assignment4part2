package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {
    public void SaveTodoLists(ActionEvent actionEvent) {
        //use the current list of todolists to run user.savetodolists
    }

    public void LoadTodoLists(ActionEvent actionEvent) {
        //use a file prompt to select a path
        //use the loadtodolists function to ADD to the current lists
    }

    public void SelectTodoList(ActionEvent actionEvent) {
        //save the selected index of the list
    }

    public void DeleteTodoList(ActionEvent actionEvent) {
        //remove the selected index from the current lists using list functions
    }

    public void AddTodoList(ActionEvent actionEvent) {
        //use lists add to add a blank list on the to a new index
    }

    public void LaunchListView(ActionEvent actionEvent) throws IOException{
        Parent listView = FXMLLoader.load(getClass().getResource("EditTodoListPage.fxml"));
        Scene listViewScene = new Scene(listView);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(listViewScene);
        window.show();
        //pass the current lists to the new view
    }
}
