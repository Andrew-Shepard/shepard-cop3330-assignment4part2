package ucf.assignments;

import java.util.Date;

public class Item {
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

}
