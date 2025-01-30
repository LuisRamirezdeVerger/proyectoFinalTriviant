package com.example.triviant;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Llamar al method para escribir datos
        FirebaseWriteTest firebaseWriteTest = new FirebaseWriteTest();
        firebaseWriteTest.writeData();
        //setContentView(R.layout.activity_main);
       // Testing
    }
}