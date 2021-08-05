package com.example.group3.douglasletstalk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.view.MotionEvent;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.utility.DatabaseHelper;
import com.example.utility.Event;

import java.util.ArrayList;

public class ViewEventsActivity extends AppCompatActivity {

    DatabaseHelper DB;

    ArrayList<String> allEvents;

    ListView eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_events);

        eventList = (ListView) findViewById(R.id.eventList);

        allEvents = new ArrayList<>();

        String[] events = DB.getEventsAvailable();
        for(String event : events){
            Event newEvent = DB.getEventById(event);
            allEvents.add(newEvent.getGroupName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allEvents);
        eventList.setAdapter(adapter);
        eventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) eventList.getItemAtPosition(position);
               // Toast.makeText(MainActivity.this,clickedItem,Toast.LENGTH_LONG).show();
            }
        });

    }
}
