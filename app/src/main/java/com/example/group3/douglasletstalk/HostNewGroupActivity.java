package com.example.group3.douglasletstalk;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utility.DatabaseHelper;
import com.example.utility.Event;

public class HostNewGroupActivity extends AppCompatActivity {

    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_new_group);

        //get the elements
        final EditText nameText = (EditText) findViewById(R.id.GroupNameInput);
        final EditText descriptionText = (EditText) findViewById(R.id.GroupNameInput);
        final EditText coordinatorText = (EditText) findViewById(R.id.GroupNameInput);

        //get a action listener
        Button finishButton = findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the values from the elements
                String newName = nameText.getText().toString();
                String newDescription = descriptionText.getText().toString();
                String newCoordinator = coordinatorText.getText().toString();

                Context context = getApplicationContext();
                CharSequence txt;
                Toast toast;
                //if all the fields are filled continue with the proccess else inform the user to to fill the rest out
                if(newName != "" && newDescription != "" && newCoordinator != ""){

                    //create a new event object
                    String eventID = newName+"12345";
                    Event newEvent = new Event(eventID, newName, newDescription, newCoordinator, "");
                    //if creating the event is a success, push it to the DB
                    if(newEvent != null) {
                        DB.insertEvent(newEvent);
                        txt = "Event Created";
                        toast = Toast.makeText(context, txt, Toast.LENGTH_SHORT);
                        toast.show();
                        startActivity(new Intent(HostNewGroupActivity.this, UserDashboard.class));
                    }
                    //else let the user know it failed
                    else{
                        txt = "Something failed while making the event";
                        toast = Toast.makeText(context, txt, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }else{
                    txt = "You need to fill in all the fields";
                    toast = Toast.makeText(context, txt, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }


}
