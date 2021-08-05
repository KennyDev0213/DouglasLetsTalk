package com.example.group3.douglasletstalk;

import java.util.ArrayList;
import java.util.Iterator;

public class Event {

    String groupID;
    String coordinatorID;
    String dateOfCreation;

    public Event(String groupID, String coordinatorID, String dateOfCreation) {
        this.groupID = groupID;
        this.coordinatorID = coordinatorID;
        this.dateOfCreation = dateOfCreation;
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
