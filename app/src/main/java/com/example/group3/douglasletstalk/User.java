package com.example.group3.douglasletstalk;

public class User extends Person{
    private int ID;
    private String password;
    private String loginStatus;

    public User(int ID, String password, String firstName, String lastName){
        super(firstName, lastName);
        this.ID = ID;
        this.password = password;
    }

    public void setLoginStatus(String newStatus){
        this.loginStatus = newStatus;
    }

    public boolean verifyPassword(String password){
        return this.password == password;
    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    @Override
    public void updateProfile(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    protected void updatePassword(String password){
        this.password = password;
    }
}
