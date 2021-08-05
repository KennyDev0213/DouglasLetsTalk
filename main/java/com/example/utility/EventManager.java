package com.example.utility;

import java.util.ArrayList;

public class EventManager {

    //we will want to connect this to the database (club table);
    ArrayList<String> EventIdList = new ArrayList<>();

    //the database DAO
    DatabaseHelper EventDAO;

    //creates a new event/club/group
    public Event createEvent(String groupName, String groupDescription, String contactInfo, Person organizer){
        String newEventId = generateEventID(organizer);
        Event newEvent = new Event(newEventId, groupDescription, organizer.getUserID() , "");
        EventDAO.insertEvent(newEvent);
        EventIdList.add(newEvent.getGroupID());
        return newEvent;
    }

    //to remove an event from the database via
    public boolean removeEvent(String eventID){
        if(EventIdList.contains(eventID)){
            int index = EventIdList.indexOf(eventID);
            EventIdList.remove(index);
            EventDAO.removeEventById(eventID);
            return true;
        }
        else
            return false;
    }

    //to generate the ID will be the username of the organizer + size of the list
    private String generateEventID(Person organizer){
        String newID = organizer.getUserName() + EventIdList.size();
        return  newID;
    }

}
