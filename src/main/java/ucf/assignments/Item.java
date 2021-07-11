package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.util.Date;
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Shepard
 */
public class Item {

    int item_id;
    SimpleStringProperty description;
    Boolean completion_status = false;
    LocalDate due_date;
    int MAX_DESCRIPTION_LENGTH = 256;

    public Item (String description, Boolean completion_status, LocalDate due_date){
        int description_length = description.length() > MAX_DESCRIPTION_LENGTH ? MAX_DESCRIPTION_LENGTH : description.length();
        this.description = new SimpleStringProperty(description.substring(0,description_length));
        this.completion_status = completion_status;
        this.due_date = due_date;
    }

    public void setDescription(String description){
        this.description = new SimpleStringProperty(description);
    }
    public void setDue_date(LocalDate due_date){this.due_date = due_date;}
    public void setCompletion_status(Boolean completion_status) { this.completion_status = completion_status; }
    public LocalDate getDue_date(){ return due_date; }
    public String getDescription(){ return description.get(); }
    public Boolean getCompletion_status(){ return completion_status; }

}
