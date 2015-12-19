package com.example.mike.mseapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SchedulingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduling);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                addButtonAction(view);
            }
        });

        AdapterView.OnItemSelectedListener onSpinner =
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {
                        Toast.makeText(parent.getContext(), "Selected: " + position, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {
                    }
                };

        String[] locations ={"Hawk Valley", "Jockey's Ridge", "Campbell's Woods", "Cooper Lake"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        locations);
        Spinner spinner =
                (Spinner)  findViewById(R.id.spinner);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(onSpinner);
    }

    private void addButtonAction(View view) {
        System.out.println("Add Button pressed");

        //TODO edit to retrieve from logged on user
        // get name
        String name = "";
        TextView nameText = (TextView) findViewById(R.id.nameEditText);
        if(!nameText.getText().toString().equalsIgnoreCase(name)) {
            name = nameText.getText().toString();
        } else {
            name = "Michael Norris";
        }

        // get date/time
        Date date = Calendar.getInstance().getTime();
        TextView dateText = (TextView) findViewById(R.id.dateEditText);
        TextView timeText = (TextView) findViewById(R.id.timeEditText);
        String dateString = dateText.getText().toString();
        String timeString = timeText.getText().toString();
        String mydateStr = "/10/07/2013 12:00:00 AM";
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            date = df.parse(dateString+" "+timeString);
            System.out.println("mvn mydate: "+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("mvn Date: "+dateString);
        System.out.println("mvn Time: "+timeString);

        //get
        String email = "";
        TextView emailText = (TextView) findViewById(R.id.emailEditText);
        if(!emailText.getText().toString().equalsIgnoreCase(email)) {
            email = emailText.getText().toString();
        } else {
            email = "michaelv.norris@gmail.com";
        }

/*
        //TODO modify for scheduling
        ScheduleEntry sched = new ScheduleEntry(name, location, uLicense, date);
        ScheduleMgr.addNewAppt(sched);
        showApptActivity();

    }



    private void showSchedActivity() {
        Intent intent = new Intent(this,ScheduleListActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_edit_appt) {
            showApptActivity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    } */
    } }
