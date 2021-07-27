package com.example.group3.douglasletstalk;

import java.util.ArrayList;
import java.util.Iterator;

public class Event implements EventInterface {

    int groupID = 0;
    String groupName = "";
    String groupDescription = "";
    String contactInfo = "";
    ArrayList<User> members = null;
    User organizer = null;

    @Override
    public int getGroupID() {
        return groupID;
    }

    @Override
    public String getGroupName() {
        return groupName;
    }

    @Override
    public String getGroupDescription() {
        return groupDescription;
    }

    @Override
    public String getContactInfo() {
        return contactInfo;
    }

    @Override
    public User[] getMembers() {
        User[] userArray = new User[this.members.size()];
        Iterator<User> memberIterator = this.members.iterator();
        int pos = 0;
        while(memberIterator.hasNext()){
            userArray[pos] = memberIterator.next();
            pos++;
        }
        return userArray;
    }

    @Override
    public User getOrganizer() {
        return organizer;
    }

    @Override
    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    @Override
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    @Override
    public boolean createGroup() {
        return false;
    }

    @Override
    public boolean deleteGroup() {
        return false;
    }

    @Override
    public boolean viewGroup() {
        return false;
    }

    @Override
    public boolean joinGroup(User newMember) {
        return this.members.add(newMember);
    }

    @Override
    public boolean leaveGroup(User member) {
        if (this.members.contains(member)){
            return this.members.remove(member);
        }
        else {
            return false;
        }
    }
}
