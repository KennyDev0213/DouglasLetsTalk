package com.example.utility;

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
    Person[] getMembers();

    /**
     *
     * @return the group organizer
     */
    Person getOrganizer();

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
    boolean joinGroup(Person newMember);

    /**
     * allows the user to leave a group
     * @param member The member that must be removed
     * @return returns true if successful, false if unsuccessful
     */
    boolean leaveGroup(Person member);
}
