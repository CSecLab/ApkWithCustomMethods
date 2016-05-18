package com.example.apkwithcustommethods;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomMethods customMethods = new CustomMethods();
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "APK WITH CUSTOM METHODS", Toast.LENGTH_LONG);
        toast.show();
    }
}
