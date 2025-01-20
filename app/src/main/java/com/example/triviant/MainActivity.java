package com.example.triviant;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

import com.example.triviant.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        binding.buttonCard.setOnClickListener(v -> {
            Random random = new Random();
            int movement = random.nextInt(6)+1;
            System.out.println(movement);
            openOtherclass(movement);
        });
    }

    private void openOtherclass(int movement) {
        Intent intent = new Intent(this, Otherclass.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }


}