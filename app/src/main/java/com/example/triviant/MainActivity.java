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
            if(movement == 1){
                binding.card.setBackgroundResource(R.drawable.one);
            }else if (movement == 2){
                binding.card.setBackgroundResource(R.drawable.two);
            }else if (movement == 3){
                binding.card.setBackgroundResource(R.drawable.three);
            }else if (movement == 4){
                binding.card.setBackgroundResource(R.drawable.four);
            }else if (movement == 5){
                binding.card.setBackgroundResource(R.drawable.five);
            }else {
                binding.card.setBackgroundResource(R.drawable.six);
            }
            openOtherclass(movement);

        });
    }

    private void openOtherclass(int movement) {
        Intent intent = new Intent(this, Otherclass.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }


}