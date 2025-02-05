package com.example.triviant.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


import java.io.*;

public class Client extends Thread {
    private static String playerName;
    private static int playerPosition = 0;  // Posición inicial del jugador

    public Client (String playerName, int playerPosition) throws IOException {
        this.playerName = playerName;
        this.playerPosition = playerPosition;
    }

    @Override
    public void run(){
        String SERVER_ADDRESS = "localhost";
        int SERVER_PORT = 40404;
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            System.out.println("Connected to server at " + SERVER_ADDRESS + ":" + SERVER_PORT);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Recibir mensaje de bienvenida
            String serverMessage = in.readUTF();
            System.out.println(serverMessage);

            // Leer nombre del jugador
            serverMessage = in.readUTF();
            System.out.println(serverMessage);
            playerName = serverMessage.split(":")[1].trim(); // Asumiendo que el servidor envía algo como "Your player name: Player 1"


            // Esperar hasta que el juego empiece
            while (true) {
                serverMessage = in.readUTF();
                System.out.println(serverMessage);

                // Si el juego ha comenzado, empezar a jugar
                if (serverMessage.equals("The game has begun! It's time to start.")) {
                    break;
                }
            }


            // Bucle de juego (el jugador sigue recibiendo turnos y enviando comandos)
            while (true) {
                // Esperar el turno del jugador
                serverMessage = in.readUTF();
                System.out.println(serverMessage);

                if (serverMessage.contains("It's your turn")) {
                    // Esperar al jugador para que mueva
                    System.out.print("Enter command (e.g., /move): ");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String command = reader.readLine();

                    // Enviar comando al servidor
                    out.writeUTF(command);

                    // Recibir respuesta del servidor (actualización del estado del jugador)
                    serverMessage = in.readUTF();
                    System.out.println(serverMessage);
                }
            }

        } catch (IOException e) {
            System.out.println("Error connecting to server: " + e.getMessage());
        }
    }
}