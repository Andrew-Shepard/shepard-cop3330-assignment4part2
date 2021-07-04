package ucf.assignments;
import java.util.Date;
import java.util.List;

public class User {
    List<TodoList> lists;
    public void loadTodoLists(){
        //open json
        //for each todolist in the json
            //add each object to lists
    }
   // public TodoList getActiveList(int index){
        //return lists<index>
    //}
    public void addNewTodoList(){
        //
    }
    public void removeExistingTodoList(){

    }
    public void setTitle(TodoList tl){

    }
    public void addItem(String description, Boolean completion_status, Date due_date){

    }
    public void removeItem(TodoList tl){

    }
    public void editItemDescription(TodoList tl, Item i){

    }
    public void editItemDueDate(TodoList tl, Item i) {

    }
    public void completeItem(TodoList tl, Item i){

    }
    public void displayCompleteItems(TodoList tl){

    }
    public void displayIncompleteItems(TodoList tl){

    }
    public void displayAllItems(TodoList tl){

    }
}
