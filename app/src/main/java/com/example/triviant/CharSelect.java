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
    private int selectedCharacterResourceId = -1;

    ImageView buttonSmart;
    ImageView buttonBuff;
    ImageView buttonWizzard;
    ImageView buttonZombie;
    ImageView backInfo;
    ImageView buttonBackInfo;
    ImageView classwood;
    ImageView classinfo;
    ImageView classinfo2;
    TextView className;
    TextView classinfotext;
    TextView classinfotext2;
    ImageView playerclass;
    ImageView buttonChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_char_select);

        buttonSmart = findViewById(R.id.smart);
        buttonBuff = findViewById(R.id.buff);
        buttonWizzard = findViewById(R.id.wizzard);
        buttonZombie = findViewById(R.id.zombie);
        backInfo = findViewById(R.id.backinfo);
        buttonBackInfo = findViewById(R.id.backtoinfo);
        classwood = findViewById(R.id.classname);
        classinfo = findViewById(R.id.info1);
        classinfo2 = findViewById(R.id.info2);
        className = findViewById(R.id.classN);
        classinfotext = findViewById(R.id.classinfo1);
        classinfotext2 = findViewById(R.id.classinfo2);
        playerclass = findViewById(R.id.Playerclass);
        buttonChoose = findViewById(R.id.buttonChoose);

        buttonSmart.setOnClickListener(v ->
        {
            openUI2();
            closeUI();
            className.setText(R.string.gifted);
            classinfotext.setText(R.string.giftedinfo);
            classinfotext2.setText(R.string.giftedinfo2);
            playerclass.setImageResource(R.drawable.friki);
            selectedCharacterResourceId = R.drawable.friki;
        });
        buttonBuff.setOnClickListener(v ->
        {
            openUI2();
            closeUI();
            className.setText(R.string.athlete);
            classinfotext.setText(R.string.athleteinfo);
            classinfotext2.setText(R.string.athleteinfo2);
            playerclass.setImageResource(R.drawable.buffman);
            selectedCharacterResourceId = R.drawable.buffman;
        });
        buttonWizzard.setOnClickListener(v ->
        {
            openUI2();
            closeUI();
            className.setText(R.string.wizzard);
            classinfotext.setText(R.string.wizzardinfo);
            classinfotext2.setText(R.string.wizzardinfo2);
            playerclass.setImageResource(R.drawable.wizzard);
            selectedCharacterResourceId = R.drawable.wizzard;
        });
        buttonZombie.setOnClickListener(v ->
        {
            openUI2();
            closeUI();
            className.setText(R.string.zombie);
            classinfotext.setText(R.string.zombieinfo);
            classinfotext2.setText(R.string.zombieinfo2);
            playerclass.setImageResource(R.drawable.zombie);
            selectedCharacterResourceId = R.drawable.zombie;
        });
        buttonChoose.setOnClickListener(v ->
        {
            Intent intent = new Intent(this, WaitingRoom.class);
            intent.putExtra("selectedCharacter", selectedCharacterResourceId);
            startActivity(intent);
            openUI();
            closeUI2();
        });
        buttonBackInfo.setOnClickListener(v ->
        {
            openUI();
            closeUI2();
        });
    }

    void openBack() {
        Intent intent = new Intent(this, WaitingRoom.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }

    void closeUI(){
        buttonSmart.setVisibility(View.GONE);
        buttonBuff.setVisibility(View.GONE);
        buttonZombie.setVisibility(View.GONE);
        buttonWizzard.setVisibility(View.GONE);
    }
    void openUI(){
        buttonSmart.setVisibility(View.VISIBLE);
        buttonBuff.setVisibility(View.VISIBLE);
        buttonZombie.setVisibility(View.VISIBLE);
        buttonWizzard.setVisibility(View.VISIBLE);
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
    void openUI2(){
        backInfo.setVisibility(View.VISIBLE);
        buttonBackInfo.setVisibility(View.VISIBLE);
        classwood.setVisibility(View.VISIBLE);
        classinfo.setVisibility(View.VISIBLE);
        classinfo2.setVisibility(View.VISIBLE);
        className.setVisibility(View.VISIBLE);
        classinfotext.setVisibility(View.VISIBLE);
        classinfotext2.setVisibility(View.VISIBLE);
        playerclass.setVisibility(View.VISIBLE);
        buttonChoose.setVisibility(View.VISIBLE);
    }
}