package ucf.assignments;

import java.util.List;
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Shepard
 */
public class TodoList {
    String title;
    List<Item> items;
    public TodoList(String title){
        this.title = title;
    }
    public void sortItems(){

    }
    public void setTitle(String title){
        this.title = title;
    }
}
