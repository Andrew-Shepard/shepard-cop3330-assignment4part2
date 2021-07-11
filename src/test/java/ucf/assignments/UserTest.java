package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void findItem_index_locates_an_item() {
        //create user object
        User u = new User();

        //use the function
        Item expected = new Item("ABC",Boolean.FALSE, LocalDate.now());
        //load sample data (Default is Example.json)
        ObservableList<Item> loaded_list = FXCollections.observableArrayList();
        for(Item item : u.loadItems()){
            loaded_list.add(item);
        }
        u.setTodolist(loaded_list);
        //add expected object at the end of the list
        u.getTodolist().add(expected);
        //see if it finds this item at the last index on the list
        assertEquals(u.getTodolist().size()-1, u.findItem_index(expected));

    }

    @Test
    void loadItems_Creates_a_list() {
        //create user object
        User u = new User();
        u.setFilePath("resources/Example.json");
        //run the function
        //if user's lists has an index greater than 0 then it has created a list
        assertTrue(u.loadItems().size() > 0);
    }

    @Test
    void saveTodoLists() {
        //create user object
        User u = new User();
        u.setFilePath("resources/saveTodoListsTest.json");
        //add an item to the list
        u.addItem("A",Boolean.FALSE,LocalDate.now());
        //run the save function
        u.saveTodoLists();
        //run the load function on the saved file
        ObservableList<Item> loaded_list = FXCollections.observableArrayList();
        for(Item item : u.loadItems()){
            loaded_list.add(item);
        }
        u.setTodolist(loaded_list);
        //assert if the loaded list has a size
        assertTrue(u.getTodolist().size() > 0);
    }

    @Test
    void addItem() {
    }

    @Test
    void removeItem() {
    }

    @Test
    void editItemDescription() {
    }

    @Test
    void editItemDueDate() {
    }

    @Test
    void editItemCompetionStatus() {
    }

    @Test
    void getCompleteItems() {
    }

    @Test
    void getIncompleteItems() {
    }


}