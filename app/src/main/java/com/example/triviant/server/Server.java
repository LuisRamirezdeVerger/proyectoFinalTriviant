package com.example.triviant.server;

import java.io.*;
import java.util.*;
import java.net.*;

public class Server {
    private final int MIN_PLAYERS = 2;
    private final int MAX_PLAYERS = 6;
    private ArrayList<Socket> clientSockets;
    private boolean gameStarted = false;
    private int connectedPlayers = 0;

    public void executeServer(){
        clientSockets = new ArrayList<>();
        System.out.println("Server started. Waiting for players on port 4040 ");

        try(ServerSocket serverSocket = new ServerSocket(4040)){
            while (connectedPlayers < MAX_PLAYERS && !gameStarted){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Player connected: " + clientSocket.getInetAddress());

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                connectedPlayers++;
                clientSockets.add(clientSocket);
                out.writeUTF("Connected to server, waiting to start. ");

                if(connectedPlayers <= MIN_PLAYERS){
                    out.writeUTF("You're the host, press start to begin the game. ");
                    String message = in.readUTF();
                    if (message.equalsIgnoreCase("/start")) {
                        gameStarted = true;
                        beginGame();
                    }
                }
            }
        } catch (Exception e){
            System.out.println("Error al iniciar el servidor. " + e);
        }
    }

    private void beginGame(){
        System.out.println("The game has begun with " + connectedPlayers + "players. ");
        for (Socket socket : clientSockets){
            try{
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("The game has begun! ");


            } catch (Exception e){
                System.out.println("Error initializing the game. " + e);
            }
        }
    }


}


