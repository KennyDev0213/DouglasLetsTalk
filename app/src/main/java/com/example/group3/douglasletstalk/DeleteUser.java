package com.example.group3.douglasletstalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteUser extends AppCompatActivity {

    EditText userID;
    Button delete;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);

        userID = (EditText) findViewById(R.id.userID);
        delete = (Button) findViewById(R.id.btndelete);

        db = DatabaseHelper.getInstance(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = userID.getText().toString();

                Boolean result = db.checkIfPersonExists(id);
                if(result == false){
                    Toast.makeText(DeleteUser.this, "User is not exits", Toast.LENGTH_SHORT).show();
                }else{
                    db.removePersonById(id);
                    Toast.makeText(DeleteUser.this, "User is deleted", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(DeleteUser.this , AdminDashboard.class);
                    startActivity(intent);
                }
            }
        });

    }
}