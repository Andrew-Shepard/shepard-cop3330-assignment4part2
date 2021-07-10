package ucf.assignments;

import java.util.Date;
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Shepard
 */
public class Item {

    int item_id;
    String description;
    Boolean completion_status = false;
    String due_date;

    public Item (String description, Boolean completion_status, String due_date){
        this.description = description;
        this.due_date = due_date;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public void setDue_date(String due_date){this.due_date = due_date;}
    public void setCompletion_status(Boolean completion_status) { this.completion_status = completion_status; }

}
