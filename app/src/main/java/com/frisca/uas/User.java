package com.frisca.uas;

public class User {

    public String name, lasMessage, lastMsgTime, phoneNo, country;
    public int imageId;

    public User(String name, String lasMessage, String lastMsgTime, String phoneNo, String country, int imageId) {
        this.name = name;
        this.lasMessage = lasMessage;
        this.lastMsgTime = lastMsgTime;
        this.phoneNo = phoneNo;
        this.country = country;
        this.imageId = imageId;
    }

}
