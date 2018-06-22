package com.saslesh.simsapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentProfile extends AppCompatActivity {

    //database declaration
    private DatabaseReference studentProfile;
    private DatabaseReference testReference;

    //static user details
    String NAME;
    String rollNO;
    String CLASS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        studentProfile = FirebaseDatabase.getInstance().getReference();

        final TextView name = (TextView) findViewById(R.id.setName);
        final TextView Class = (TextView) findViewById(R.id.setClass);
        final TextView RollNo = (TextView) findViewById(R.id.setRollNo);



        Intent intent = getIntent();
        final String user = intent.getStringExtra("User");

        studentProfile.child("Students").child(user).child("Name").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                name.setText("Name: " + value);
                //name.setBackgroundResource(R.drawable.wood1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        studentProfile.child("Students").child(user).child("Class").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Class.setText("Class: " + value);
                //Class.setBackgroundResource(R.drawable.wood2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        studentProfile.child("Students").child(user).child("UserName").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                RollNo.setText("Roll No: " + value);
                //RollNo.setBackgroundResource(R.drawable.wood3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Button marks = (Button) findViewById(R.id.button8);
        marks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentProfile.this,StudentMarksPage.class);
                intent.putExtra("User",user);
                startActivity(intent);
            }
        });









    }


}

