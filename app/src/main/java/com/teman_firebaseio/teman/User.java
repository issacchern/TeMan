package com.teman_firebaseio.teman;

/**
 * Created by Issac on 9/20/2015.
 */
public class User {
    private String phoneNumber;
    private String title;
    private String description;
    private String name;

    public User() {}

    public User(String title,String description,String name, String phoneNumber) {
        this.title = title;
        this.description = description;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getphoneNumber() {return phoneNumber;}

    public String getTitle() {return title;}

    public String getDescription() {return description;}

    public String getName() {return name;}
}