package com.example.mike.mseapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IncidentReportActivity extends AppCompatActivity {

    IncidentMgr incidentMgr = IncidentMgr.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        String[] tripType ={"Hunting", "Fishing"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        tripType);
        Spinner spinner =
                (Spinner)  findViewById(R.id.spinner);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(onSpinner);
    }

    private void addButtonAction(View view) {
        System.out.println("Add Button pressed");

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

        // get location
        String location = "";
        TextView locationText = (TextView) findViewById(R.id.locationEditText);
        if(!locationText.getText().toString().equalsIgnoreCase(location)) {
            location = locationText.getText().toString();
        } else {
            location = "MSE";
        }

        // get latitude
        double latitude;
        TextView latitudeText = (TextView) findViewById(R.id.latEditText2);
        if(!latitudeText.getText().toString().equalsIgnoreCase("")) {
            latitude = Double.parseDouble(latitudeText.getText().toString());
        } else {
            latitude = 39.974491;
        }

        // get longitude
        double longitude;
        TextView longitudeText = (TextView) findViewById(R.id.longitudeEditText3);
        if(!longitudeText.getText().toString().equalsIgnoreCase("")) {
            longitude = Double.parseDouble(longitudeText.getText().toString());
        } else {
            longitude = -74.976683;
        }
        // get trip info
        String tripInfo = "";
        TextView tripInfoText = (TextView) findViewById(R.id.tripInfoEditText4);
        if(!tripInfoText.getText().toString().equalsIgnoreCase(tripInfo)) {
            tripInfo = tripInfoText.getText().toString();
        } else {
            tripInfo = "Look out for polar bears.";
        }
        // add appoint to mgr
        Incidents appt = new Incidents(date, location, latitude, longitude,tripInfo);
        incidentMgr.addNewAppt(appt);
        showApptActivity();

    }



    private void showApptActivity() {
        Intent intent = new Intent(this,IncidentListActivity.class);
        startActivity(intent);
    }

    private void showAllMapButtonAction() {

        System.out.println("mvn showAllCalled()");


        Intent intent = new Intent(this,MapsActivity.class);
        intent.putExtra("lat", "0.0");
        intent.putExtra("long", "0.0");
        intent.putExtra("index", "-1");
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
        if (id == R.id.action_show_all) {
            showAllMapButtonAction();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
