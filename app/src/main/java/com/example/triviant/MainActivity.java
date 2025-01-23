package com.example.triviant;

import static java.util.Collections.list;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

import com.example.triviant.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ImageView card;
    Button buttonCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        card = findViewById(R.id.card);
        buttonCard = findViewById(R.id.buttonCard);

        //binding.card.setImageDrawable(R.drawable.one);

        buttonCard.setOnClickListener(v -> {
            Random random = new Random();
            int movement = random.nextInt(6)+1;
            System.out.println(movement);

            switch (movement)
            {
                case(1):
                    card.setBackgroundResource(R.drawable.one);
                    break;
                case(2):
                    card.setBackgroundResource(R.drawable.two);
                    break;
                case(3):
                    card.setBackgroundResource(R.drawable.three);
                    break;
                case(4):
                    card.setBackgroundResource(R.drawable.four);
                    break;
                case(5):
                    card.setBackgroundResource(R.drawable.five);
                    break;
                case(6):
                    card.setBackgroundResource(R.drawable.six);
                    break;
            }

            openOtherclass(movement);

        });
    }

    private void openOtherclass(int movement) {
        Intent intent = new Intent(this, Otherclass.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }


}