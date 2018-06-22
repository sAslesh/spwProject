package com.saslesh.simsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_page);

        final EditText et1 = (EditText) findViewById(R.id.editText);
        final EditText et2 = (EditText) findViewById(R.id.editText2);
        final EditText et3 = (EditText) findViewById(R.id.editText3);

        Button AdminLogIn = (Button) findViewById(R.id.button2);

        AdminLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().equals("sAslesh") && et2.getText().toString().equals("pass") && et3.getText().toString().equals("code")) {
                    Toast.makeText(getBaseContext(),"Log In Successful",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AdminLoginPage.this,AdminDashBoard.class);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(getBaseContext(),"Log In Unsuccessful",Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(AdminLoginPage.this,LoginPage.class);
                    startActivity(intent1);
                }
            }
        });




    }



}



