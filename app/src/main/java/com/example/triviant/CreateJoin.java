package com.example.triviant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CreateJoin extends AppCompatActivity {

    ImageView buttonCreate;
    ImageView buttonJoin;
    ImageView buttonSettings;
    ImageView buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_join);

        buttonCreate = findViewById(R.id.ButtonCreate);
        buttonJoin = findViewById(R.id.ButtonJoin);
        buttonSettings = findViewById(R.id.settings);
        buttonBack = findViewById(R.id.back);

        buttonSettings.setOnClickListener(v -> {
            openSettings();
        });

        buttonCreate.setOnClickListener(v -> {
            openCreate();
        });

        buttonJoin.setOnClickListener(v -> {
            openJoin();
        });

        buttonBack.setOnClickListener(v -> {
            openBack();
        });
    }

    void openSettings() {
        Intent intent = new Intent(this, Settings.class); // Crear el intent
        startActivity(intent); // Lanzar el intent
    }

    void openCreate() {
        Intent intent = new Intent(this, CreateRoom.class); // Crear el intent
        startActivity(intent); // Lanzar el intent
    }

    void openJoin() {
        Intent intent = new Intent(this, JoinRoom.class); // Crear el intent
        startActivity(intent); // Lanzar el intent
    }

    void openBack() {
        Intent intent = new Intent(this, Title.class); // Crear el intent
        startActivity(intent); // Lanzar el intent
    }
}
