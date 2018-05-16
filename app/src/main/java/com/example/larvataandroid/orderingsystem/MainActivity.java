package com.example.larvataandroid.orderingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    ModelClass modelClass;
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        modelClass = new ModelClass();
//        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        databaseReference = FirebaseDatabase.getInstance().getReference("kid");
        insertData();

    }
    public void insertData(){
        modelClass.setPhoneNumber("122211");
        modelClass.setUserName("ju2222nz1hen");

        databaseReference.child("users").push().setValue(modelClass);

    }
//    public void job1(){
//        Bundle bundle = new Bundle();
//        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(R.id.button2));
//        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Button");
//        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
//    }
}
