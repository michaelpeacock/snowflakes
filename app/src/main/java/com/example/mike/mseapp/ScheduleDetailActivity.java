package com.example.mike.mseapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Administrator on 12/18/15.
 */
public class ScheduleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editSchedButtonAction();
                Snackbar.make(view, "Appointment Updated!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //delApptButtonAction();
                //showMapButtonAction();
                Snackbar.make(view, "Appointment Deleted!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ScheduleDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(ScheduleDetailFragment.ARG_ITEM_ID));
            ScheduleDetailFragment fragment = new ScheduleDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.appointment_detail_container, fragment)
                    .commit();
        }
    }

    private void editSchedButtonAction() {
        int index = Integer.parseInt(getIntent().getStringExtra(ScheduleDetailFragment.ARG_ITEM_ID));
        System.out.println("mvn index="+index);
        ScheduleMgr.getInstance().editSched(index);

        // refresh stale data
        finish();
        startActivity(getIntent());
    }

    private void delApptButtonAction() {
        int index = Integer.parseInt(getIntent().getStringExtra(ScheduleDetailFragment.ARG_ITEM_ID));
        System.out.println("mvn index=" + index);
        ScheduleMgr.getInstance().deleteSched(index);

        // go back to list after delete
        Intent intent = new Intent(this,ScheduleListActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, ScheduleListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
