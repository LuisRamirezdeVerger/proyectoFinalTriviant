package com.example.triviant;

import android.os.Bundle;
import android.widget.Button;
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

    private Socket mSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_room);

        try {
            mSocket = IO.socket("http://tu-servidor-url:puerto");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        mSocket.connect();

        mSocket.on("waiting", args -> runOnUiThread(() -> {
            TextView statusTextView = findViewById(R.id.statusTextView);
            statusTextView.setText(getString(R.string.waiting));
        }));

        mSocket.on("ready", args -> runOnUiThread(() -> {
            TextView statusTextView = findViewById(R.id.statusTextView);
            statusTextView.setText(getString(R.string.full));
            // Aquí puedes iniciar la siguiente actividad o la pantalla del juego
        }));

        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(v -> {
            mSocket.disconnect();
            finish(); // Salir de la sala de espera
        });
    }
}