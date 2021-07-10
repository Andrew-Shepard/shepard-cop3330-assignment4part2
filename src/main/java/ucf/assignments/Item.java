package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Shepard
 */
public class Item {

    int item_id;
    SimpleStringProperty description;
    Boolean completion_status = false;
    SimpleStringProperty due_date;

    public Item (String description, Boolean completion_status, String due_date){
        this.description = new SimpleStringProperty(description);
        this.due_date = new SimpleStringProperty(due_date);
    }

    public void setDescription(String description){
        this.description = new SimpleStringProperty(description);
    }
    public void setDue_date(String due_date){this.due_date = new SimpleStringProperty(due_date);}
    public void setCompletion_status(Boolean completion_status) { this.completion_status = completion_status; }
    public String getDue_date(){ return due_date.get(); }
    public String getDescription(){ return description.get(); }
    public Boolean getCompletion_status(){ return completion_status; }

}
