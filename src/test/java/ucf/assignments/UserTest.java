package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Shepard
 */
class UserTest {
    @Test
    void user_can_store_1000_items() {
        //create a new user object
        User u = new User();
        //add over a thousand items
        for (int i = 0; i < 1001; i++) {
            u.addItem("test", Boolean.FALSE, LocalDate.now());
        }
        //see if it is holding over a thousand items
        assertTrue(u.getTodolist().size() > 1000);
    }

    @Test
    void an_item_cannot_have_over_256_characters() {
        //Create a new item with a string of 256+ characters
        Item i = new Item("You will submit a link to your GitHub page. Please ensure that your repository is private until 12 hours after the due date, at which point you may make it public. If you need myself or a TA to look at your code, you may share your repository with us - just ask us for our GitHub user names.It should go without saying that if we suspect you have copied code from another student, you will be referred to the office of student conduct and receive a Z grade for the course.If we cannot access your repository, or if you provide an invalid link, you will receive a 0 - please double check your submission once it has been made.Late submissions will receive a 0 as per the syllabus.Note: All of your design artifacts from [Part 1] should be part of [Part 2], except where they have been updated to reflect changes in your design.",
                Boolean.FALSE,
                LocalDate.now());
        //check the length of the description for 256
        assertEquals(256, i.getDescription().length());
    }

    @Test
    void findItem_index_locates_an_item() {
        //create user object
        User u = new User();

        //use the function
        Item expected = new Item("ABC", Boolean.FALSE, LocalDate.now());
        //load sample data (Default is Example.json)
        ObservableList<Item> loaded_list = FXCollections.observableArrayList();
        for (Item item : u.loadItems()) {
            loaded_list.add(item);
        }
        u.setTodolist(loaded_list);
        //add expected object at the end of the list
        u.getTodolist().add(expected);
        //see if it finds this item at the last index on the list
        assertEquals(u.getTodolist().size() - 1, u.findItem_index(expected));

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
        u.addItem("A", Boolean.FALSE, LocalDate.now());
        //run the save function
        u.saveTodoLists();
        //run the load function on the saved file
        ObservableList<Item> loaded_list = FXCollections.observableArrayList();
        for (Item item : u.loadItems()) {
            loaded_list.add(item);
        }
        u.setTodolist(loaded_list);
        //assert if the loaded list has a size
        assertTrue(u.getTodolist().size() > 0);
    }

    @Test
    void addItem_shows_increased_index() {
        //create user object
        User u = new User();
        int expected = u.getTodolist().size() + 1;
        //add an item to the list
        u.addItem("", Boolean.FALSE, LocalDate.now());
        assertEquals(expected, u.getTodolist().size());
    }

    @Test
    void removeItem_shows_decreased_index() {
        //create user object
        User u = new User();
        int expected = 2;
        //add 3 items to the list
        u.addItem("", Boolean.FALSE, LocalDate.now());
        u.addItem("", Boolean.FALSE, LocalDate.now());
        u.addItem("", Boolean.FALSE, LocalDate.now());
        u.removeItem(u.getTodolist().get(0));
        assertEquals(expected, u.getTodolist().size());
    }

    @Test
    void editItemDescription_shows_changed_description() {
        //create user object
        User u = new User();
        String expected = "expected";
        //create item object
        u.addItem("", Boolean.FALSE, LocalDate.now());
        //run edititemdescription
        u.editItemDescription(u.getTodolist().get(0),expected);
        //assert if the changed string equals what it was changed to
        assertEquals(expected,u.getTodolist().get(0).getDescription());
    }

    @Test
    void editItemDueDate_shows_changed_value() {
        //create user object
        User u = new User();
        LocalDate expected = LocalDate.now();
        //create item object
        u.addItem("", Boolean.FALSE, LocalDate.MAX);
        //run edititemduedate
        u.editItemDueDate(u.getTodolist().get(0),expected);
        //assert if the changed string equals what it was changed to
        assertEquals(expected,u.getTodolist().get(0).getDue_date());
    }

    @Test
    void editItemCompetionStatus_shows_changed_value() {
        //create user object
        User u = new User();
        Boolean expected = Boolean.TRUE;
        //create item object
        u.addItem("", Boolean.FALSE, LocalDate.MAX);
        //run edititemduedate
        u.editItemCompetionStatus(u.getTodolist().get(0),expected);
        //assert if the changed string equals what it was changed to
        assertEquals(expected,u.getTodolist().get(0).getCompletion_status());
    }

    @Test
    void getCompleteItems_returns_only_complete_items() {
        //create user object
        User u = new User();
        //create a sample list for user
        u.addItem("", Boolean.FALSE, LocalDate.now());
        u.addItem("", Boolean.FALSE, LocalDate.now());
        u.addItem("", Boolean.TRUE, LocalDate.now());
        u.addItem("", Boolean.TRUE, LocalDate.now());
        u.addItem("", Boolean.TRUE, LocalDate.now());
        //check that the length of the return list matches the expected amount of true items
        assertEquals(3,u.getCompleteItems().size());
    }

    @Test
    void getIncompleteItems_returns_only_incomplete_items() {
        //create user object
        User u = new User();
        //create a sample list for user
        u.addItem("", Boolean.FALSE, LocalDate.now());
        u.addItem("", Boolean.FALSE, LocalDate.now());
        u.addItem("", Boolean.TRUE, LocalDate.now());
        u.addItem("", Boolean.TRUE, LocalDate.now());
        u.addItem("", Boolean.TRUE, LocalDate.now());
        //check that the length of the return list matches the expected amount of False items
        assertEquals(2,u.getIncompleteItems().size());
    }
    @Test
    void getAllItems_returns_the_entire_list(){
        //create user object
        User u = new User();
        //create a sample list for user
        u.addItem("", Boolean.FALSE, LocalDate.now());
        u.addItem("", Boolean.FALSE, LocalDate.now());
        u.addItem("", Boolean.TRUE, LocalDate.now());
        u.addItem("", Boolean.TRUE, LocalDate.now());
        u.addItem("", Boolean.TRUE, LocalDate.now());
        //check that the length of the return list matches the expected amount of False items
        assertEquals(5,u.getAllItems().size());
    }
    @Test
    void saveTodoLists_creates_a_JSON_file(){
        //create user object
        User u = new User();
        //create a sample list for user
        u.addItem("", Boolean.FALSE, LocalDate.now());
        u.addItem("", Boolean.FALSE, LocalDate.now());
        u.addItem("", Boolean.TRUE, LocalDate.now());
        u.addItem("", Boolean.TRUE, LocalDate.now());
        u.addItem("", Boolean.TRUE, LocalDate.now());
        //set filepath to some testing location
        String TEST_PATH = "resources/UserTest.json";
        u.setFilePath(TEST_PATH);
        u.saveTodoLists();
        //check if the file exists
        File f = new File(TEST_PATH);
        assertTrue(f.exists());
    }
    @Test
    void loadTodoLists_loads_a_saved_JSON_file(){
        //create user object
        User u = new User();
        //create a sample list for user
        u.addItem("a", Boolean.FALSE, LocalDate.now());
        u.addItem("a", Boolean.FALSE, LocalDate.now());
        u.addItem("a", Boolean.TRUE, LocalDate.now());
        u.addItem("a", Boolean.TRUE, LocalDate.now());
        u.addItem("a", Boolean.TRUE, LocalDate.now());
        //set filepath to some testing location
        String TEST_PATH = "resources/UserTest.json";
        u.setFilePath(TEST_PATH);
        u.saveTodoLists();
        //load the file from the testing location
        List<Item> test = u.loadItems();
        //check if it loaded the expected amount of items
        assertEquals(5,test.size());
    }
    @Test
    void cleartodolist_gets_rid_of_all_elements() {
        //create user object
        User u = new User();
        //create a sample list for user
        u.addItem("a", Boolean.FALSE, LocalDate.now());
        u.addItem("a", Boolean.FALSE, LocalDate.now());
        u.addItem("a", Boolean.TRUE, LocalDate.now());
        u.addItem("a", Boolean.TRUE, LocalDate.now());
        u.addItem("a", Boolean.TRUE, LocalDate.now());
        //clear the list
        u.clearTodoList();
        //assert that the lists length is 0
        assertEquals(0,u.getTodolist().size());
    }


}