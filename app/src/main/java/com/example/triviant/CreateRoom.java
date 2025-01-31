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

    ImageView buttonBack = findViewById(R.id.back);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_room);


        buttonBack.setOnClickListener(v ->
        {
            openBack();
        });
    }

    void openBack() {
        Intent intent = new Intent(this, Title.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }
}