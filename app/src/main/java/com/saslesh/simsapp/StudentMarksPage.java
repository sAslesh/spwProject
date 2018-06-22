package com.saslesh.simsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class StudentMarksPage extends AppCompatActivity {

    private DatabaseReference testReference;
    private RecyclerView marksRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_marks_page);

        Intent intent = getIntent();
        String User = intent.getStringExtra("User");

        testReference = FirebaseDatabase.getInstance().getReference().child("Students").child(User).child("test");
        testReference.keepSynced(true);

        marksRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        marksRecyclerView.setHasFixedSize(true);
        marksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<UserMarks, UserMarksViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<UserMarks, UserMarksViewHolder>
                (UserMarks.class, R.layout.cardview, UserMarksViewHolder.class, testReference) {
            @Override
            protected void populateViewHolder(UserMarksViewHolder viewHolder, UserMarks model, int position) {
                viewHolder.setdate(model.getDate());
                viewHolder.setmarks(model.getMarks());
                viewHolder.setSub(model.getSub());
            }
        };

        marksRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    public static class UserMarksViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public UserMarksViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setSub(String sub) {
            TextView post_sub = (TextView)mView.findViewById(R.id.textView12);
            post_sub.setText("Subject:" + sub);
        }

        public void setdate(String date) {
            TextView post_sub = (TextView)mView.findViewById(R.id.textView13);
            post_sub.setText("Date: " + date);
        }

        public void setmarks(String marks) {
            TextView post_marks = (TextView)mView.findViewById(R.id.textView14);
            post_marks.setText("Marks: " +marks);
        }
    }

}


