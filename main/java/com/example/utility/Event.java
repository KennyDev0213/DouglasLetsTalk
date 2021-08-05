package com.example.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {

    String groupID;
    String coordinatorID;
    String groupDescription;
    String dateOfCreation;

    public Event(String groupID, String groupDescription, String coordinatorID, String dateOfCreation) {

        this.groupID = groupID;
        this.coordinatorID = coordinatorID;
        this.groupDescription = groupDescription;
        //if the date is unspecified, assume it was created now
        if(dateOfCreation == "")
            this.dateOfCreation = dateOfCreation;
        else{
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date now = new Date();
            this.dateOfCreation = formatter.format(now);
        }
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getCoordinatorID() {
        return coordinatorID;
    }

    public void setCoordinatorID(String coordinatorID) {
        this.coordinatorID = coordinatorID;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
