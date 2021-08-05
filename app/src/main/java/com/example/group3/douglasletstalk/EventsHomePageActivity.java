package com.example.group3.douglasletstalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.utility.DatabaseHelper;
import com.example.utility.Event;
import com.example.utility.Person;

public class EventsHomePageActivity extends AppCompatActivity {

    DatabaseHelper DB;

    TextView groupName;
    TextView groupCoordinator;
    TextView groupMembers;
    TextView groupDescripion;

    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_home_page);

        groupName = (TextView) findViewById(R.id.GroupName);
        groupCoordinator = (TextView)findViewById(R.id.Coordinators);
        groupMembers = (TextView) findViewById(R.id.Members);
        groupDescripion = (TextView) findViewById(R.id.Description);

        backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsHomePageActivity.this, LoginActivity.class));
            }
        });
    }

    public void displayEvent(Event event){

        groupName.setText(event.getGroupName());

        Person coord = DB.getPersonById(event.getCoordinatorID());
        groupCoordinator.setText(coord.getUserName());

        String Members = "";



        groupDescripion.setText(event.getGroupDescription());
    }


}