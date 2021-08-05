package com.example.group3.douglasletstalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utility.Admin;
import com.example.utility.DatabaseHelper;

public class AdminLogin extends AppCompatActivity {
    EditText adminID, adminPassword;
    Button btnLogin;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        adminID = (EditText) findViewById(R.id.adminID);
        adminPassword = (EditText) findViewById(R.id.adminPassword);
        btnLogin = (Button) findViewById(R.id.adminLogin);

        db = DatabaseHelper.getInstance(this);

        Admin admin = new Admin("Admin", "Roy", "admin");
        db.insertAdmin(admin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = adminID.getText().toString();
                String pass = adminPassword.getText().toString();


                Boolean authenticate = db.checkIfAdminExists(id, pass);
                if (id.equals("") || pass.equals("")) {
                    Toast.makeText(AdminLogin.this, "Please enter id and password", Toast.LENGTH_SHORT).show();
                } else  if (authenticate) {
                    Intent intent = new Intent(AdminLogin.this, AdminDashboard.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(AdminLogin.this, "Password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}