package com.example.triviant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JoinRoom extends AppCompatActivity {

    ImageView buttonBack;
    ImageView buttonSettings;
    ImageView buttonJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_join_room);

        buttonBack = findViewById(R.id.back);
        buttonSettings = findViewById(R.id.settings);
        buttonJoin = findViewById(R.id.buttonJoinRoom);


        buttonBack.setOnClickListener(v ->
        {
            openBack();
        });
        buttonSettings.setOnClickListener(v ->
        {
            openSettings();
        });
        buttonJoin.setOnClickListener(v ->
        {
            //Insertar código para entrar en la sala en la base de datos
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
