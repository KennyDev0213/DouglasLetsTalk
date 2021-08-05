package com.example.group3.douglasletstalk;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utility.EventManager;

public class HostNewGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_new_group);

        final EditText nameText = (EditText) findViewById(R.id.GroupNameInput);
        final EditText descriptionText = (EditText) findViewById(R.id.GroupNameInput);
        final EditText coordinatorText = (EditText) findViewById(R.id.GroupNameInput);

        Button finishButton = findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = nameText.getText().toString();
                String newDescription = descriptionText.getText().toString();
                String newCoordinator = coordinatorText.getText().toString();

                Boolean added = EventManager.createEvent(newName, newDescription, newCoordinator);

                Context context = getApplicationContext();
                CharSequence txt;
                Toast toast;
                if(added){
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