package com.example.triviant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreateRoom extends AppCompatActivity {

    ImageView buttonBack;
    ImageView buttonSettings;
    ImageView buttonCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_room);

        buttonBack = findViewById(R.id.back);
        buttonSettings = findViewById(R.id.settings);
        buttonCreate = findViewById(R.id.buttonCreateRoom);


        buttonBack.setOnClickListener(v ->
        {
            openBack();
        });
        buttonSettings.setOnClickListener(v ->
        {
            openSettings();
        });
        buttonCreate.setOnClickListener(v ->
        {
            //Insertar código para crear la sala en la base de datos
            openCharSelect();
        });
    }

    void openBack() {
        Intent intent = new Intent(this, CreateJoin.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }

    void openSettings() {
        Intent intent = new Intent(this, Settings.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }

    void openCharSelect() {
        Intent intent = new Intent(this, CharSelect.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }
}