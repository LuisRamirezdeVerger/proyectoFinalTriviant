package com.example.triviant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CharSelect extends AppCompatActivity {

    ImageView buttonBack = findViewById(R.id.back);
    ImageView buttonSmart = findViewById(R.id.smart);
    ImageView buttonBuff = findViewById(R.id.buff);
    ImageView buttonWizzard = findViewById(R.id.wizzard);
    ImageView buttonZombie = findViewById(R.id.zombie);
    ImageView backInfo = findViewById(R.id.backinfo);
    ImageView buttonBackInfo = findViewById(R.id.backtoinfo);
    ImageView classwood = findViewById(R.id.classname);
    ImageView classinfo = findViewById(R.id.info1);
    ImageView classinfo2 = findViewById(R.id.info2);
    TextView className = findViewById(R.id.classN);
    TextView classinfotext = findViewById(R.id.classinfo1);
    TextView classinfotext2 = findViewById(R.id.classinfo2);
    ImageView playerclass = findViewById(R.id.Playerclass);
    ImageView buttonChoose = findViewById(R.id.buttonChoose);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_char_select);

        buttonBack.setOnClickListener(v ->
        {
            openBack();
        });
        buttonSmart.setOnClickListener(v ->
        {
            closeUI();
            className.setText(R.string.gifted);
            classinfotext.setText(R.string.giftedinfo);
            classinfotext2.setText(R.string.giftedinfo2);
        });
        buttonBuff.setOnClickListener(v ->
        {
            closeUI();
            className.setText(R.string.athlete);
            classinfotext.setText(R.string.athleteinfo);
            classinfotext2.setText(R.string.athleteinfo2);
        });
        buttonWizzard.setOnClickListener(v ->
        {
            closeUI();
            className.setText(R.string.wizzard);
            classinfotext.setText(R.string.wizzardinfo);
            classinfotext2.setText(R.string.wizzardinfo2);
        });
        buttonZombie.setOnClickListener(v ->
        {
            closeUI();
            className.setText(R.string.zombie);
            classinfotext.setText(R.string.zombieinfo);
            classinfotext2.setText(R.string.zombieinfo2);
        });
        buttonChoose.setOnClickListener(v ->
        {
            //Lógica de selección de personaje
        });
        buttonBackInfo.setOnClickListener(v ->
        {
            closeUI2();
        });
    }

    void openBack() {
        Intent intent = new Intent(this, WaitingRoom.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }

    void closeUI(){
        buttonBack.setVisibility(View.GONE);
        buttonSmart.setVisibility(View.GONE);
        buttonBuff.setVisibility(View.GONE);
        buttonZombie.setVisibility(View.GONE);
        buttonWizzard.setVisibility(View.GONE);
    }

    void closeUI2(){
        backInfo.setVisibility(View.GONE);
        buttonBackInfo.setVisibility(View.GONE);
        classwood.setVisibility(View.GONE);
        classinfo.setVisibility(View.GONE);
        classinfo2.setVisibility(View.GONE);
        className.setVisibility(View.GONE);
        classinfotext.setVisibility(View.GONE);
        classinfotext2.setVisibility(View.GONE);
        playerclass.setVisibility(View.GONE);
        buttonChoose.setVisibility(View.GONE);
    }
}