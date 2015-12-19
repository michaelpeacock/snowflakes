package com.example.mike.mseapp;

import java.text.DateFormat;
import java.util.Date;


public class Incidents {


    private Date date;
    private String location;
    private double latitude;
    private double longitude;
    private String tripInfo;
    private static int globalId = 0;
    private int id = 0;


    public Incidents(Date date, String location, double latitude, double longitude, String tripInfo) {
        this.date = date;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tripInfo = tripInfo;
        id = globalId++;
    }

    @Override
    public String toString() {
        DateFormat.getDateTimeInstance();
        return
                "Date:" +  DateFormat.getDateInstance().format(date) + '\n' +
                "Time:" +DateFormat.getTimeInstance().format(date) + '\n' +
                "ID#:" + id + '\n' +
                "Location:" + location + '\n' +
                "Latitude:" + latitude + '\n' +
                "Longitude:" + longitude + '\n' +
                "Trip Information:" + tripInfo;
    }


    public void setDate(Date date) {
        this.date = date;
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


    public int getId() {
        return id;
    }
}
