package ucf.assignments;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.google.gson.*;
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Shepard
 */
public class User {
    List<Item> todolist;
    private String filePath;

    // *** Constructor ***
    public User(String filePath) {
        this.filePath = filePath;
    }

    public void setFilePath(String filePath) { this.filePath = filePath; }

    public List<Item> getTodolist() { return todolist; }

    public List<Item> loadItems(){
        try {
            //open json
            File input = new File(filePath);
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();
            JsonArray jsonArrayofItems = fileObject.get("items").getAsJsonArray();
            List<Item> items = new ArrayList<>();
            //for each item in the json
            for(JsonElement itemElement : jsonArrayofItems){
                JsonObject itemJsonObject = itemElement.getAsJsonObject();

                String description = itemJsonObject.get("description").getAsString();
                Boolean completion_status = itemJsonObject.get("completion_status").getAsBoolean();
                String due_date = itemJsonObject.get("due_date").getAsString();
                //add each object to lists
                Item item = new Item(description, completion_status, due_date);
                items.add(item);
            }
            return items;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Item getActiveList(int index){
        return todolist.get(index);

    }
    public void saveTodoLists(){
        //for each item in tl
        Gson gson = new Gson();
        try {
            for(Item item : todolist){
                //add the items to the json
                gson.toJson(item, new FileWriter(filePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void removeExistingTodoList(int index){
        //lists.remove index
        todolist.remove(index);
    }
    public void addItem(String description, Boolean completion_status, String due_date){
        //lists add new item with description, completion and due date
        Item added_item = new Item(description,completion_status,due_date);
        todolist.add(added_item);   
    }
    public void removeItem(int index){
        //tl remove the indexed item from the list
        todolist.remove(index);
    }
    public void editItemDescription(Item i, String description){
        //i will be referenced from lists
        //i set item description to the string using item.setdescription
        i.setDescription(description);
    }
    public void editItemDueDate(Item i, String due_date) {
        //i will be referenced from lists
        //set i's description using item's setdescription
        i.setDue_date(due_date);
    }
    public void editItemCompetionStatus(Item i,Boolean status){
        //i will be referenced from lists
        //use item's set completionstatus to move the item to true
        i.setCompletion_status(status);
    }
    public List<Item> getCompleteItems(){
        //create a temporary list
        List<Item> complete_items = new ArrayList<>();
        //for every item in tl
        for(Item item : todolist){
            // check if the item has true for completion status
            if(item.completion_status == true){
                //if it does add it to the temporary list
                complete_items.add(item);
            }
        }
        return complete_items;
    }
    public List<Item> getIncompleteItems(){
        //create a temporary list
        List<Item> complete_items = new ArrayList<>();
        //for every item in tl
        for(Item item : todolist){
            // check if the item has false for completion status
            if(item.completion_status == false){
                //if it does add it to the temporary list
                complete_items.add(item);
            }
        }
        return complete_items;

    }
    public List<Item> getAllItems(){
        return todolist;
    }
}
