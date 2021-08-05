package com.example.group3.douglasletstalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utility.DatabaseHelper;

public class DeleteEvent extends AppCompatActivity {
    EditText eventID;
    Button delete;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_event);

        eventID = (EditText) findViewById(R.id.eventID);
        delete = (Button) findViewById(R.id.btndelete);

        db = DatabaseHelper.getInstance(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = eventID.getText().toString();

                Boolean result = db.checkIfEventExists(id);
                if(id.equals("")){
                    Toast.makeText(DeleteEvent.this, "Enter a event ID to delete", Toast.LENGTH_SHORT).show();
                }else if (result){
                    db.deleteEvent(id);
                    Toast.makeText(DeleteEvent.this, "Event is deleted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DeleteEvent.this , AdminDashboard.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(DeleteEvent.this, "Event is not exits", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}