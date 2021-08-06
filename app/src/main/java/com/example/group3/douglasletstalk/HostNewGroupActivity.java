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

import java.time.LocalDate;

public class HostNewGroupActivity extends AppCompatActivity {

    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_new_group);

        final EditText nameText = (EditText) findViewById(R.id.GroupNameInput);
        final EditText descriptionText = (EditText) findViewById(R.id.GroupNameInput);
        final EditText coordinatorText = (EditText) findViewById(R.id.GroupNameInput);

        DB = DatabaseHelper.getInstance(this);

        Button finishButton = findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = nameText.getText().toString();
                String newDescription = descriptionText.getText().toString();
                String newCoordinator = coordinatorText.getText().toString();
                String createTime = LocalDate.now().toString();


                String eventID = newName+ "123";
                Event newEvent = new Event(eventID, newName, newDescription, newCoordinator, createTime);
                DB.insertEvent(newEvent);

                Context context = getApplicationContext();
                CharSequence txt;
                Toast toast;
                if(newEvent != null){
                    txt = "Your Event has been created!";
                    toast = Toast.makeText(context, txt, Toast.LENGTH_SHORT);
                    toast.show();
                    startActivity(new Intent(HostNewGroupActivity.this,UserDashboard.class));
                }else{
                    txt = "Something failed while making the event";
                    toast = Toast.makeText(context, txt, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }


}