package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Shepard
 */
public class ItemSaveIsScuffed {
    int id;
    String description;
    Boolean completion_status = false;
    String due_date;


    public ItemSaveIsScuffed (String description, Boolean completion_status, String due_date){
        this.description = description;
        this.completion_status = completion_status;
        this.due_date = due_date;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public void setDue_date(String due_date){this.due_date = due_date;}
    public void setCompletion_status(Boolean completion_status) { this.completion_status = completion_status; }
    public String getDue_date(){ return due_date; }
    public String getDescription(){ return description; }
    public Boolean getCompletion_status(){ return completion_status; }

}
