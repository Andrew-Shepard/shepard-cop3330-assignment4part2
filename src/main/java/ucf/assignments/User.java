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
   public TodoList getActiveList(int index){
        //return lists<index>
        return null;
    }
    public void saveTodoLists(List<TodoList> tl){
      //for each item in tl
        //add the TodoList parts to the json
        //access the parts of the respective items and add them to the json as well
    }
    public void addNewTodoList(){
        //lists.add , should just add a blank list
    }
    public void removeExistingTodoList(int index){
       //lists.remove index
    }
    public void setTitle(TodoList tl, String title){
      //tl.settitle to title
    }
    public void addItem(String description, Boolean completion_status, Date due_date){
      //lists add new item with description, completion and due date
    }
    public void removeItem(TodoList tl, int index){
      //tl remove the indexed item from the list
    }
    public void editItemDescription(Item i, String description){
     //i will be referenced from lists
      //i set item description to the string using item.setdescription
    }
    public void editItemDueDate(Item i) {
     //i will be referenced from lists
     //set i's description using item's setdescription
    }
    public void completeItem(Item i){
      //i will be referenced from lists
     //use item's set completionstatus to move the item to true
    }
    public TodoList displayCompleteItems(TodoList tl){
      //create a temporary list
      //for every item in tl
     // check if the item has true for completion status
     //if it does add it to the temporary list
     //for every item in the temporary list
     //show it in the text field
     return null;
    }
    public void displayIncompleteItems(TodoList tl){
     //create a temporary list
     //for every item in tl
     // check if the item has false for completion status
     //if it does add it to the temporary list
     //for every item in the temporary list
     //show it in the text field

    }
    public void displayAllItems(TodoList tl){
       //for every item in the list
       //show it in the text field
    }
}
