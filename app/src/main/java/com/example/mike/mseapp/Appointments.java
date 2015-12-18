package com.example.mike.mseapp;

import java.text.DateFormat;
import java.util.Date;


public class Appointments {


    private String name;
    private String phone;
    private Date date;
    private String email;
    private String location;
    private double latitude;
    private double longitude;
    private String tripInfo;
    private static int globalId = 0;
    private int id = 0;


    public Appointments(String name, String phone, Date date, String email, String location, double latitude, double longitude, String tripInfo) {
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.email = email;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tripInfo = tripInfo;
        id = globalId++;
    }

    @Override
    public String toString() {
        DateFormat.getDateTimeInstance();
        return  "Name:" + name + '\n' +
                "E-mail:" + email + '\n' +
                "Phone:" +  phone + '\n' +
                "Date:" +  DateFormat.getDateInstance().format(date) + '\n' +
                "Time:" +DateFormat.getTimeInstance().format(date) + '\n' +
                "ID#:" + id + '\n' +
                "Location:" + location + '\n' +
                "Latitude:" + latitude + '\n' +
                "Longitude:" + longitude + '\n' +
                "Trip Information:" + tripInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getTripInfo() {
        return tripInfo;
    }

    public double getLat() {
        return latitude;
    }

    public double getLong() {
        return longitude;
    }

    public Date getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}
