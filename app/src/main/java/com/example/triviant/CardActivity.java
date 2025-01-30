package com.example.triviant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

import com.example.triviant.databinding.ActivityCardBinding;

public class CardActivity extends AppCompatActivity {

    ImageView card;
    Button buttonCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        ActivityCardBinding binding = ActivityCardBinding.inflate(getLayoutInflater());

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
                    card.setImageResource(R.drawable.one);
                    System.out.println(movement);
                    card.invalidate();
                    break;
                case(2):
                    card.setImageResource(R.drawable.two);
                    System.out.println(movement);
                    card.invalidate();
                    break;
                case(3):
                    card.setImageResource(R.drawable.three);
                    System.out.println(movement);
                    card.invalidate();
                    break;
                case(4):
                    card.setImageResource(R.drawable.four);
                    System.out.println(movement);
                    card.invalidate();
                    break;
                case(5):
                    card.setImageResource(R.drawable.five);
                    System.out.println(movement);
                    card.invalidate();
                    break;
                case(6):
                    card.setImageResource(R.drawable.six);
                    System.out.println(movement);
                    card.invalidate();
                    break;
            }

            //openOtherclass(movement);

        });
    }

    private void openOtherclass(int movement) {
        Intent intent = new Intent(this, Otherclass.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }


}