package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void loadTodoLists_creates_a_list() {
        //create user object
        //run the function
        //if user's lists has an index greater than 0 then it has created a list
    }
    @Test
    void loadTodoLists_counts_the_json_correctly() {
        //create user object
        //create a json with a predetermined amount of todolists
        //run the function
        //assert if user's lists has the expected size
    }

    @Test
    void getActiveList() {
        //not used in current implementation
        //create user object
        //assert if the found todolist equals the actual todolist in that index
    }

    @Test
    void saveTodoLists() {
        //create user object
        //add a todolist to the main lists
        //run the save function
        //run the load function on the saved file
        //assert if the loaded list has a size
    }

    @Test
    void addNewTodoList() {
        //create user object
        //create a variable with the original length of lists
        //run the function
        //see if it added one to lists length
    }

    @Test
    void removeExistingTodoList() {
        //create user object
        //create a variable with the original length of lists
        //run the function
        //see if it removed one to lists length
    }

    @Test
    void setTitle() {
        //create user object
        //use the function
        //assert if the title property of a function equals to what it was set to
    }

    @Test
    void addItem() {
        //create user object
        //record the length of the todolist
        //use the function
        //assert if the length equals to what was recorded previously plus one
    }

    @Test
    void removeItem() {
        //create user object
        //record the length of the todolist
        //use the function
        //assert if the length equals to what was recorded previously minus one
    }

    @Test
    void editItemDescription() {
        //create user object
        //use the function
        //assert if the description property of a function equals to what it was set to
    }

    @Test
    void editItemDueDate() {
        //create user object
        //use the function
        //assert if the due date property of a function equals to what it was set to
    }

    @Test
    void completeItem() {
        //create user object
        //use the function
        //assert if the completion status property of a function equals to what it was set to
    }

    @Test
    void displayCompleteItems() {
        //create user object
        //create a list with a counted number of complete items and incomplete items
        //use the function
        //assert if the function result's length equals the expected number of complete items
    }

    @Test
    void displayIncompleteItems() {
        //create user object
        //create a list with a counted number of complete items and incomplete items
        //use the function
        //assert if the function result's length equals the expected number of incomplete items
    }

    @Test
    void displayAllItems() {
        //create user object
        //create a list with a counted number of complete items and incomplete items
        //use the function
        //assert if the length is expected
    }
}