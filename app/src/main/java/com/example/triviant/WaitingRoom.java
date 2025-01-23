package com.example.triviant;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_room);

        playerGrid = findViewById(R.id.playerGrid);

        Button startButton = findViewById(R.id.startButton);
        Button exitButton = findViewById(R.id.exitButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para comenzar el juego
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para salir
                finish();
            }
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
}
