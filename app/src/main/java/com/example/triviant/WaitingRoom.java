package com.example.triviant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class WaitingRoom extends AppCompatActivity {

    private GridLayout playerGrid;
    ImageView startButton = findViewById(R.id.StartButton);
    ImageView buttonBack = findViewById(R.id.back);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_room);

        playerGrid = findViewById(R.id.playerGrid);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para comenzar el juego
                openBoard();
            }
        });

        buttonBack.setOnClickListener(v ->
        {
            openBack();
        });

        // Simulando jugadores añadiéndose a la sala
        for (int i = 1; i <= 4; i++) {
            addPlayerToGrid(i, i <= 2); // Ejemplo: 2 jugadores listos
        }
    }

    private void addPlayerToGrid(int playerNumber, boolean isReady) {
        View playerView = getLayoutInflater().inflate(R.layout.player_view, playerGrid, false);
        ImageView playerImage = playerView.findViewById(R.id.playerImage);
        TextView playerStatus = playerView.findViewById(R.id.playerStatus);

        // Aquí puedes añadir lógica para cargar la imagen del jugador
        playerImage.setImageResource(R.drawable.ic_player_default);

        if (isReady) {
            playerStatus.setText(getString(R.string.ready));
        }

        playerGrid.addView(playerView);
    }

    void openBack() {
        Intent intent = new Intent(this, CreateJoin.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }

    void openBoard() {
        Intent intent = new Intent(this, Board.class); // Crear el intent

        startActivity(intent); // Lanzamos el intent
    }
}
