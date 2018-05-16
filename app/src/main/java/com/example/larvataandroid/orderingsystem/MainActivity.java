package com.example.larvataandroid.orderingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    ModelClass modelClass;

    private FirebaseAnalytics mFirebaseAnalytics;
    private Button sendData;
    private EditText textData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        modelClass = new ModelClass();
//        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        databaseReference = FirebaseDatabase.getInstance().getReference("kid");
        buttonClick();

    }
    public void buttonClick(){
        sendData = findViewById(R.id.button2);
        textData = findViewById(R.id.editText);
        onClick();
    }
    private void onClick(){
        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }
    public void insertData(){
        modelClass.setPhoneNumber("user1");
        modelClass.setUserName(textData.getText().toString());

        databaseReference.child("users").push().setValue(modelClass);
        Toast.makeText(MainActivity.this,"hi kid u already SENT :"+textData.getText().toString() ,Toast.LENGTH_LONG).show();


    }
//    public void job1(){
//        Bundle bundle = new Bundle();
//        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(R.id.button2));
//        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Button");
//        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
//    }
}
