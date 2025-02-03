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

    ImageView buttonBack = findViewById(R.id.back);
    ImageView buttonSettings = findViewById(R.id.settings);
    ImageView buttonJoin = findViewById(R.id.buttonJoinRoom);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_join_room);


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
            openWaitingRoom();
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

    void openWaitingRoom() {
        Intent intent = new Intent(this, WaitingRoom.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }
}
