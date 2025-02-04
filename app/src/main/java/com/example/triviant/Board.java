package com.example.triviant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class Board extends AppCompatActivity {

    ImageView card;
    Button buttonCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_board);

        card = findViewById(R.id.card);
        buttonCard = findViewById(R.id.buttonCard);

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

            /*ubi actual=ubi actual + movement
            jugadoreste.setUbi(ubi actual)
            openQuestion(String personaje)
            */

        });
    }

    /* void openQuestion(String personaje) {
        Intent intent = new Intent(this, Question.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }*/
}


