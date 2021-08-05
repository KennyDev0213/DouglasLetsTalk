package com.example.utility;

import java.util.ArrayList;

public class EventManager {

    //we will want to connect this to the database (club table);
    static ArrayList<String> EventIdList = new ArrayList<>();

    //the database DAO
    static DatabaseHelper EventDAO;

    //creates a new event/club/group
    static public void createEvent(Person organizer){
        String newEventId = generateEventID(organizer);
        Event newEvent = new Event(newEventId, organizer.getUserID() , "");
        EventDAO.insertEvent(newEvent);
        EventIdList.add(newEvent.getGroupID());
    }

    //to remove an event from the database via eventID
    static public boolean removeEvent(String eventID){
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
    static private String generateEventID(Person organizer){
        String newID = organizer.getUserName() + EventIdList.size();
        return  newID;
    }

}
