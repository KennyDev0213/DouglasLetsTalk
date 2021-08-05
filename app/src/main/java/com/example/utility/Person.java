package com.example.utility;

import java.io.Serializable;

public class Person implements Serializable {

    String userID;
    String userName;
    String dateOfJoin;
    String password;

    public Person(String userID, String userName, String dateOfJoin, String password) {
        this.userID = userID;
        this.userName = userName;
        this.dateOfJoin = dateOfJoin;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(String dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPerson(){
        if(getUserID().equals("") || getUserName().equals("") || getPassword().equals("")){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public String toString() {
        return getUserID() + ", " + getUserName();
    }

    public String display(){
        return "ID: " + getUserID() + "\n" +
                "Name: " + getUserName() + "\n" +
                "Password: " + getPassword();
    }
}
