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

public class RegisterActivity extends AppCompatActivity {
    EditText userName, userID, userPassword;
    Button btncreate;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = (EditText) findViewById(R.id.NameHint);
        userID = (EditText) findViewById(R.id.SIDHint) ;
        userPassword = (EditText) findViewById(R.id.passwordHint);
        btncreate = (Button) findViewById(R.id.btnCreate);


        db = DatabaseHelper.getInstance(this);

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = userName.getText().toString();
                String id = userID.getText().toString();
                String pass = userPassword.getText().toString();
                String createTime = LocalDate.now().toString();

                Boolean result = db.checkIfPersonExists(id, pass);

                Person person = new Person(id, name, createTime, pass);

                if(name.equals("") || id.equals("") || pass.equals("")){
                    Toast.makeText(RegisterActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }else {
                    if(result == true){
                        Toast.makeText(RegisterActivity.this, "User already exits", Toast.LENGTH_SHORT).show();
                    }else{
                        db.insertPerson(person);

                        Toast.makeText(RegisterActivity.this, "User create successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this , AdminDashboard.class);
                        startActivity(intent);
                    }
                }

            }
        });



    }
}