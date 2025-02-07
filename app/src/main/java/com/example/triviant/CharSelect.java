package com.example.triviant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

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
            openBack();
        });
        buttonBuff.setOnClickListener(v ->
        {
            openBack();
        });
        buttonWizzard.setOnClickListener(v ->
        {
            openBack();
        });
        buttonZombie.setOnClickListener(v ->
        {
            openBack();
        });
    }

    void openBack() {
        Intent intent = new Intent(this, WaitingRoom.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }
}