package com.example.mike.mseapp;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Administrator on 12/18/15.
 */
public class ScheduleEntry {


    private String name;
    private String location;
    private String uLicense;
    private Date date;
    private static int globalId = 0;
    private int id = 0;
    //Time?


    public ScheduleEntry(String name, String location, String uLicense, Date date) {
        this.location = location;
        this.uLicense = uLicense;
        this.date = date;
        id = globalId++;
    }

    @Override
    public String toString() {
        DateFormat.getDateTimeInstance();
        return  "Name:" + name + '\n' +
                "Date:" +  DateFormat.getDateInstance().format(date) + '\n' +
                "Time:" +DateFormat.getTimeInstance().format(date) + '\n' +
                "ID#:" + id + '\n' +
                "Location:" + location + '\n';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }
}
