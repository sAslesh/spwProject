package com.saslesh.simsapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;
import org.json.JSONStringer;


public class StudentLoginPage extends AppCompatActivity {

    //String pwdDatabase = "null";

    //declaration of the database reference



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login_page);

        Button button = (Button) findViewById(R.id.buttonStudentLogIn);
        final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.editStudent);
                final EditText pwd = (EditText) findViewById(R.id.editStudentPwd);


                final String uName = name.getText().toString();
                final String uPwd = pwd.getText().toString();

                mDatabase.child("Students").child(uName).child("Password").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);
                        //setValue(value);
                        //Toast.makeText(getBaseContext(),value,Toast.LENGTH_SHORT).show();
                        if ( uPwd.equals(value)) {
                            Intent intent = new Intent(StudentLoginPage.this,StudentProfile.class);
                            intent.putExtra("User",uName);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getBaseContext(),"The entered password is wrong\n                          or \n               Please try Again",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(StudentLoginPage.this,StudentLoginPage.class);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getBaseContext(),"User not found",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });












    }

    /*public void setValue(String string) {
        pwdDatabase = string;
    }*/
}




