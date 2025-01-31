package com.example.triviant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreateJoin extends AppCompatActivity {

    ImageView buttonCreate = findViewById(R.id.ButtonCreate);
    ImageView buttonJoin = findViewById(R.id.ButtonJoin);
    ImageView buttonSettings = findViewById(R.id.settings);
    ImageView buttonBack = findViewById(R.id.back);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_join);

        buttonSettings.setOnClickListener(v ->
        {
            openSettings();
        });

        buttonCreate.setOnClickListener(v ->
        {
            openCreate();
        });

        buttonJoin.setOnClickListener(v ->
        {
            openJoin();
        });

        buttonBack.setOnClickListener(v ->
        {
            openBack();
        });
    }

    void openSettings() {
        Intent intent = new Intent(this, Settings.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }

    void openCreate() {
        Intent intent = new Intent(this, CreateRoom.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }

    void openJoin() {
        Intent intent = new Intent(this, JoinRoom.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }

    void openBack() {
        Intent intent = new Intent(this, Title.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }
}

