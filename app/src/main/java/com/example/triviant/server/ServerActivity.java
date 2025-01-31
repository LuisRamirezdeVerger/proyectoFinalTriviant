package com.example.triviant.server;

import android.database.Observable;
import android.os.Bundle;
import android.widget.Toast;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.appcompat.app.AppCompatActivity;

import com.example.triviant.R;

class ServerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_server);

        // Iniciar el servidor en segundo plano
        startServer();
    }

    private void startServer() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Server server = new Server();
                server.executeServer();

                // Si necesitas actualizar la UI, usa runOnUiThread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Servidor iniciado");
                    }
                });
            }
        });
    }
}
