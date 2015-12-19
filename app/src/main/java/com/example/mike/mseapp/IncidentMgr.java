package com.example.mike.mseapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by MIKE on 12/6/2015.
 */
public class IncidentMgr {

    public ArrayList<Incidents> apptList;
    private static IncidentMgr instance;
    public HashMap<Integer, Incidents> apptMap = new HashMap<Integer, Incidents>();


    public IncidentMgr(){

        apptList = new ArrayList<Incidents>();
        addFakeData("MSE", 39.974491, -74.976683,"Look out for polar bears." );
        addFakeData("Atlantic City", 39.370066, -74.411981,"I went crabbing here." );
        addFakeData("Jersey Mike's", 39.989987, -75.008992, "This place is on fire." );
        addFakeData("Chipotle", 39.944278, -74.963405, "Watch out for E. Coli" );
    }

    private void addFakeData(String location,double latitude, double longitude, String tripInfo) {
        Date date = Calendar.getInstance().getTime();

        // add appoint to mgr
        Incidents appt = new Incidents(date, location, latitude,longitude,tripInfo);
        this.addNewAppt(appt);
    }


    public boolean addNewAppt(Incidents appt) {
        apptMap.put(appt.getId(),appt);
        return apptList.add(appt);
    }

    public boolean deleteAppt(int index){
        if(apptMap.isEmpty() || !apptMap.containsKey(index)){
            return false;
        }
        Incidents appt = apptMap.remove(index);
        apptList.remove(appt);
        return true;
    }

    public boolean editAppt(int index){
        if(apptMap.isEmpty() || !apptMap.containsKey(index)){
            return false;
        }
        Incidents appt = apptMap.get(index);
        appt.setDate(new Date(0));
        return true;
    }

    public Incidents getAppt(int index){
        if(apptMap.isEmpty() || !apptMap.containsKey(index)){
            return null;
        }
        return apptMap.get(index);
    }

    public static IncidentMgr getInstance() {
        if(instance==null){
            instance = new IncidentMgr();
        }
        return instance;
    }

    
}
