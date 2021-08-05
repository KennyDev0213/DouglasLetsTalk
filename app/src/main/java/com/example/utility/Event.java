package com.example.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {

    DatabaseHelper DB;

    String groupID;
    String groupName;
    String coordinatorID;
    String groupDescription;
    String dateOfCreation;

    public Event(String groupID, String coordinatorID, String dateOfCreation) {

        this.groupID = groupID;
        this.coordinatorID = coordinatorID;
        //this.groupDescription = groupDescription;
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

    public String getGroupName(){ return this.groupName; }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public String getCoordinatorID() {
        return coordinatorID;
    }

    public Person getCoordinator(String coordinatorID){
        return DB.getPersonById(coordinatorID);
    }

    public void setCoordinatorID(String coordinatorID) {
        this.coordinatorID = coordinatorID;
    }

    public String getGroupDescription(){return this.groupDescription;}

    public void setGroupDescription(String groupDescription){
        this.groupDescription = groupDescription;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
