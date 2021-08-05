package com.example.group3.douglasletstalk;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.utility.DatabaseHelper;
import com.example.utility.Person;

import java.time.LocalDate;

public class EnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        DatabaseHelper db = DatabaseHelper.getInstance(this);

        String createTime = LocalDate.now().toString();
        Person person = new Person("3001234", "Test User", createTime, "123456");
        db.insertPerson(person);

        Button userEntry = (Button) findViewById(R.id.btnuser);
        Button adminEntry = (Button) findViewById(R.id.btnadmin);

        userEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EnterActivity.this,loginInformationActivity.class));
            }
        });

        adminEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EnterActivity.this,AdminLogin.class));
            }
        });


        Button helpButton = findViewById(R.id.helpButton);
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EnterActivity.this,HelpPageActivity.class));
            }
        });
    }
}