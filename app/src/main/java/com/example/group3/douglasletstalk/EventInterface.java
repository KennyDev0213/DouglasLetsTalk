package com.example.group3.douglasletstalk;

public interface EventInterface {
    /**
     *
     * @return the group's ID
     */
    int getGroupID();

    /**
     *
     * @return the group's name
     */
    String getGroupName();

    /**
     *
     * @return the group description
     */
    String getGroupDescription();

    /**
     *
     * @return the group description
     */
    String getContactInfo();

    /**
     *
     * @return an array of users
     */
    User[] getMembers();

    /**
     *
     * @return the group organizer
     */
    User getOrganizer();

    void setGroupID(int groupID);

    void setGroupName(String groupName);

    void setGroupDescription(String groupDescription);

    /**
     *
      * @return returns true if successful, false if unsuccessful
     */
    boolean createGroup();

    /**
     *
     * @return returns true if successful, false if unsuccessful
     */
    boolean deleteGroup();
    /**
     * @return returns true if successful, false if unsuccessful
     */
    boolean viewGroup();

    /**
     * allows the user to join the group
     * @param newMember The new member to add
     * @return returns true if successful, false if unsuccessful
     */
    boolean joinGroup(User newMember);

    /**
     * allows the user to leave a group
     * @param member The member that must be removed
     * @return returns true if successful, false if unsuccessful
     */
    boolean leaveGroup(User member);
}
