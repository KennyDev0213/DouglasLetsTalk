package com.example.group3.douglasletstalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.utility.EventManager;

public class HostNewGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_new_group);

        final EditText nameText = (EditText) findViewById(R.id.GroupNameInput);
        final EditText descriptionText = (EditText) findViewById(R.id.GroupNameInput);
        final EditText coordinatorText = (EditText) findViewById(R.id.GroupNameInput);
        final EditText memberText = (EditText) findViewById(R.id.GroupNameInput);

        Button finishButton = findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = nameText.getText().toString();
                String newDescription = descriptionText.getText().toString();
                String newCoordinator = coordinatorText.getText().toString();
                String newMembers = memberText.getText().toString();

                //EventManager.createEvent();

                startActivity(new Intent(HostNewGroupActivity.this,UserDashboard.class));
            }
        });
    }


}