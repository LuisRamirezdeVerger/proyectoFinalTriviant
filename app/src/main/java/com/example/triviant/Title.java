package com.example.triviant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.triviant.databinding.ActivityTitleBinding;

public class Title extends AppCompatActivity {

    ImageView buttonPlay;
    ImageView buttonSettings = findViewById(R.id.settings);
    ImageView buttonUser = findViewById(R.id.user);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_title);

        ActivityTitleBinding binding = ActivityTitleBinding.inflate(getLayoutInflater());

        buttonPlay = findViewById(R.id.buttonStart);

        buttonPlay.setOnClickListener(v ->
        {
            openCreateJoin();
        });
        buttonSettings.setOnClickListener(v ->
        {
            openSettings();
        });
        buttonUser.setOnClickListener(v ->
        {
            openUser();
        });
    }

    void openCreateJoin() {
        Intent intent = new Intent(this, CreateJoin.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }

    void openSettings() {
        Intent intent = new Intent(this, Settings.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }

    void openUser() {
        Intent intent = new Intent(this, User.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }
}