package com.example.triviant;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class Board extends AppCompatActivity {

    ImageView card;
    ImageView buttonCard;
    String category;
    ImageView backQuest;
    ImageView woodQuest;
    ImageView option1;
    ImageView option2;
    ImageView option3;
    ImageView option4;
    ImageView logoQuest;
    TextView question;
    TextView answer1;
    TextView answer2;
    TextView answer3;
    TextView answer4;
    ImageView result;
    TextView confirm;
    TextView resultText;
    ImageView chronowood;
    TextView chrono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_board);

        card = findViewById(R.id.card);
        buttonCard = findViewById(R.id.buttonCard);
        backQuest = findViewById(R.id.backQuest);
        woodQuest = findViewById(R.id.woodQuest);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        logoQuest = findViewById(R.id.logoQuest);
        question = findViewById(R.id.question);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        result = findViewById(R.id.result);
        confirm = findViewById(R.id.confirm);
        resultText = findViewById(R.id.correctText);
        chronowood = findViewById(R.id.chronometer);
        chrono = findViewById(R.id.numbers);

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
            openQuestion()
            */

        });
    }

    void openQuestion() {
       backQuest.setVisibility(View.VISIBLE);
       woodQuest.setVisibility(View.VISIBLE);
       option1.setVisibility(View.VISIBLE);
       option2.setVisibility(View.VISIBLE);
       option3.setVisibility(View.VISIBLE);
       option4.setVisibility(View.VISIBLE);

       switch(category)
       {
           case("sport"):
           {
               logoQuest.setVisibility(View.VISIBLE);
               logoQuest.setImageResource(R.drawable.football);
               question.setText("");
               answer1.setText("");
               answer2.setText("");
               answer3.setText("");
               answer4.setText("");
               question.setVisibility(View.VISIBLE);
               answer1.setVisibility(View.VISIBLE);
               answer2.setVisibility(View.VISIBLE);
               answer3.setVisibility(View.VISIBLE);
               answer4.setVisibility(View.VISIBLE);
               break;
           }
           case("art"):
           {
               logoQuest.setVisibility(View.VISIBLE);
               logoQuest.setImageResource(R.drawable.arte);
               question.setText("");
               answer1.setText("");
               answer2.setText("");
               answer3.setText("");
               answer4.setText("");
               question.setVisibility(View.VISIBLE);
               answer1.setVisibility(View.VISIBLE);
               answer2.setVisibility(View.VISIBLE);
               answer3.setVisibility(View.VISIBLE);
               answer4.setVisibility(View.VISIBLE);
               break;
           }
           case("history"):
           {
               logoQuest.setVisibility(View.VISIBLE);
               logoQuest.setImageResource(R.drawable.hourglass);
               question.setText("");
               answer1.setText("");
               answer2.setText("");
               answer3.setText("");
               answer4.setText("");
               question.setVisibility(View.VISIBLE);
               answer1.setVisibility(View.VISIBLE);
               answer2.setVisibility(View.VISIBLE);
               answer3.setVisibility(View.VISIBLE);
               answer4.setVisibility(View.VISIBLE);
               break;
           }
           case("videogames"):
           {
               logoQuest.setVisibility(View.VISIBLE);
               logoQuest.setImageResource(R.drawable.controller);
               question.setText("");
               answer1.setText("");
               answer2.setText("");
               answer3.setText("");
               answer4.setText("");
               question.setVisibility(View.VISIBLE);
               answer1.setVisibility(View.VISIBLE);
               answer2.setVisibility(View.VISIBLE);
               answer3.setVisibility(View.VISIBLE);
               answer4.setVisibility(View.VISIBLE);
               break;
           }
           case("geography"):
           {
               logoQuest.setVisibility(View.VISIBLE);
               logoQuest.setImageResource(R.drawable.ic_player_default);
               question.setText("");
               answer1.setText("");
               answer2.setText("");
               answer3.setText("");
               answer4.setText("");
               question.setVisibility(View.VISIBLE);
               answer1.setVisibility(View.VISIBLE);
               answer2.setVisibility(View.VISIBLE);
               answer3.setVisibility(View.VISIBLE);
               answer4.setVisibility(View.VISIBLE);
               break;
           }
           case("entertainment"):
           {
               logoQuest.setVisibility(View.VISIBLE);
               logoQuest.setImageResource(R.drawable.entretenimiento);
               question.setText("");
               answer1.setText("");
               answer2.setText("");
               answer3.setText("");
               answer4.setText("");
               question.setVisibility(View.VISIBLE);
               answer1.setVisibility(View.VISIBLE);
               answer2.setVisibility(View.VISIBLE);
               answer3.setVisibility(View.VISIBLE);
               answer4.setVisibility(View.VISIBLE);
               break;
           }
           case("culture"):
           {
               logoQuest.setVisibility(View.VISIBLE);
               logoQuest.setImageResource(R.drawable.ic_player_default);
               question.setText("");
               answer1.setText("");
               answer2.setText("");
               answer3.setText("");
               answer4.setText("");
               question.setVisibility(View.VISIBLE);
               answer1.setVisibility(View.VISIBLE);
               answer2.setVisibility(View.VISIBLE);
               answer3.setVisibility(View.VISIBLE);
               answer4.setVisibility(View.VISIBLE);
               break;
           }

       }

    }

    void closeQuestion() {
        backQuest.setVisibility(View.GONE);
        woodQuest.setVisibility(View.GONE);
        option1.setVisibility(View.GONE);
        option2.setVisibility(View.GONE);
        option3.setVisibility(View.GONE);
        option4.setVisibility(View.GONE);
        logoQuest.setVisibility(View.GONE);
        question.setVisibility(View.GONE);
        answer1.setVisibility(View.GONE);
        answer2.setVisibility(View.GONE);
        answer3.setVisibility(View.GONE);
        answer4.setVisibility(View.GONE);

    }

    void correct()
    {
        result.setVisibility(View.VISIBLE);
        resultText.setVisibility(View.VISIBLE);
        resultText.setText(R.string.corr);
        result.setImageResource(R.drawable.right);
    }

    void incorrect()
    {
        result.setVisibility(View.VISIBLE);
        resultText.setVisibility(View.VISIBLE);
        resultText.setText(R.string.incorr);
        result.setImageResource(R.drawable.wrong);
    }

    void confirm()
    {
        confirm.setVisibility(View.GONE);
        result.setVisibility(View.GONE);
        resultText.setVisibility(View.GONE);
        closeQuestion();
    }

    /*void chrono()
    {
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                long secondsRemaining = millisUntilFinished / 1000;
                chrono.setText(String.format("%02d:%02d", secondsRemaining / 60, secondsRemaining % 60));
            }

            public void onFinish() {
                chrono.setText("00:00");
            }
        }.start();
    }*/

}


