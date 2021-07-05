package ucf.assignments;

import java.util.Date;

public class Item {
    int item_id;
    String description;
    Boolean completion_status = false;
    Date due_date;

    public Item (String description, Date due_date){
        this.description = description;
        this.due_date = due_date;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public void setDue_date(Date due_date){this.due_date = due_date;}
    public void setCompletion_status(Boolean completion_status) { this.completion_status = completion_status; }

}
