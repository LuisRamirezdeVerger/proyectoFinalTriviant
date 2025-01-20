package com.example.triviant;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.*;

import com.example.triviant.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        binding.buttonCard.setOnClickListener(v -> {
            Random random = new Random(5);
            int movement = random.nextInt();
            System.out.println(movement);
            //openOtherclass();
        });
    }
/*
    private void openLogin() {
        Intent intent = new Intent(this, Otherclass.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }
*/

}