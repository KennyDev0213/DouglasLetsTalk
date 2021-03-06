package com.example.group3.douglasletstalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.utility.DatabaseHelper;
import com.example.utility.Person;

import java.time.LocalDate;

public class loginInformationActivity extends AppCompatActivity {
    EditText userID, userPassword;
    Button btnLogin;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_information);


        Button confirmButton = findViewById(R.id.userLogin);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginInformationActivity.this,UserDashboard.class));
            }
        });

        userID = (EditText) findViewById(R.id.userID);
        userPassword = (EditText) findViewById(R.id.userPassword);
        btnLogin = (Button) findViewById(R.id.userLogin);

        db = DatabaseHelper.getInstance(this);

        String createTime = LocalDate.now().toString();
       Person person = new Person("30012345", "Test User", createTime, "123456");
        db.insertPerson(person);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = userID.getText().toString();
                String pass = userPassword.getText().toString();

                Boolean authenticate = db.checkIfPersonExists(id,pass);
                Boolean result = db.checkIfPersonExists(id);

                if(id.equals("") || pass.equals("")){
                    Toast.makeText(loginInformationActivity.this, "Please enter id and password", Toast.LENGTH_SHORT).show();
                }else if(result == false){
                    Toast.makeText(loginInformationActivity.this, "User not exits", Toast.LENGTH_SHORT).show();
                }else if(authenticate){
                    Person person1 = db.getPersonById(id);
                    Intent intent = new Intent(loginInformationActivity.this , UserDashboard.class);
                    intent.putExtra("personObject", person1);
                    startActivity(intent);
                }else{
                    Toast.makeText(loginInformationActivity.this, "Password is invalid", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


}


