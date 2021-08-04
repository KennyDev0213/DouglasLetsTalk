package com.example.group3.douglasletstalk;

import java.util.ArrayList;
import java.util.HashMap;

public class EventManager {

    //we will want to connect this to the database (club table);
    ArrayList<Integer> EventIdList = new ArrayList<>();

    //EventDAO EventDB = new EventDAO();

    public Event createEvent(String groupName, String groupDescription, String contactInfo, User organizer){
        int newEventId = generateEventID(organizer);
        while(EventIdList.contains(newEventId)){
            newEventId += 1;
        }
        Event newEvent = new Event(newEventId, groupName, groupDescription, contactInfo, organizer);
        EventIdList.add(newEvent.groupID);
        return newEvent;
    }

    public void removeEvent(int eventID){

    }

    private int generateEventID(User organizer){
        int newID = organizer.lastName.hashCode()+organizer.firstName.hashCode() % EventIdList.size();
        return  newID;
    }

}
