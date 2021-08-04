package com.example.group3.douglasletstalk;

public abstract class Person {
    String firstName;
    String lastName;
    String email;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

     public abstract void login();

     public abstract void logout();

     abstract public void updateProfile(String firstName, String lastName, String email);
}
