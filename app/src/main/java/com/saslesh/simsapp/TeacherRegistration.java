package com.saslesh.simsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TeacherRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_registration);

        /*final EditText et1 = (EditText) findViewById(R.id.editTeacher);
        final EditText et2 = (EditText) findViewById(R.id.editTeacherPwd);
        final EditText et3 = (EditText) findViewById(R.id.editTeacherCode);

        final String name = et1.getText().toString();
        final String password = et2.getText().toString();
        final String code = et3.getText().toString();

        Button button = (Button) findViewById(R.id.ButtonTeacherLogIn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }); */
    }




}

/*public class Teacher{
    String Name;
    String Password;
    String SecureCode;

    Teacher(String Name,String Password,String SecureCode){
        this.Name = Name;
        this.Password = Password;
        this.SecureCode = SecureCode;
    }
}
*/

