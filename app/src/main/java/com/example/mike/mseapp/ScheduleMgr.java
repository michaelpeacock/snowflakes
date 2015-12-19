package com.example.mike.mseapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Administrator on 12/18/15.
 */
public class ScheduleMgr {
    public ArrayList<ScheduleEntry> schedList;
    private static ScheduleMgr instance;
    public HashMap<Integer, ScheduleEntry> schedMap = new HashMap<Integer, ScheduleEntry>();


    public ScheduleMgr(){

        schedList = new ArrayList<ScheduleEntry>();
        //TODO Incorrect Data
        addFakeData("MSE");
        addFakeData("Atlantic City");
        addFakeData("Jersey Mike's");
        addFakeData("Chipotle");
    }

    private void addFakeData(String location) {
        String name = "Michael Norris";
        String uLicense = "609-817-3516";
        Date date = Calendar.getInstance().getTime();

        // add appoint to mgr
        ScheduleEntry sched = new ScheduleEntry(name,location, uLicense,date);
        this.addNewSched(sched);
    }


    public boolean addNewSched(ScheduleEntry sched) {
        schedMap.put(sched.getId(),sched);
        return schedList.add(sched);
    }

    public boolean deleteSched(int index){
        if(schedMap.isEmpty() || !schedMap.containsKey(index)){
            return false;
        }
        ScheduleEntry sched = schedMap.remove(index);
        schedList.remove(sched);
        return true;
    }

    public boolean editSched(int index){
        if(schedMap.isEmpty() || !schedMap.containsKey(index)){
            return false;
        }
        ScheduleEntry sched = schedMap.get(index);
        sched.setName("Norris Michael");
        sched.setDate(new Date(0));
        return true;
    }

    public ScheduleEntry getSched(int index){
        if(schedMap.isEmpty() || !schedMap.containsKey(index)){
            return null;
        }
        return schedMap.get(index);
    }

    public static ScheduleMgr getInstance() {
        if(instance==null){
            instance = new ScheduleMgr();
        }
        return instance;
    }
}
