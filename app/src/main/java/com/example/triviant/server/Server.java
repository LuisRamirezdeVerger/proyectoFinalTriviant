package com.example.triviant.server;

import com.example.triviant.Player;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private final int MIN_PLAYERS = 2;
    private final int MAX_PLAYERS = 6;
    private final int WINNING_POSITION = 38;

    private List<Player> players;
    private List<Socket> clientSockets;
    private boolean gameStarted = false;
    private int connectedPlayers = 0;
    private int currentTurn = 0;

    public Server() {
        players = new ArrayList<>();
        clientSockets = new ArrayList<>();
    }

    public void executeServer() {
        System.out.println("Server started. Waiting for players on port 4040");
        try (ServerSocket serverSocket = new ServerSocket(4040)) {
            while (connectedPlayers < MAX_PLAYERS && !gameStarted) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Player connected: " + clientSocket.getInetAddress());

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                connectedPlayers++;
                clientSockets.add(clientSocket);
                Player newPlayer = new Player("Player " + connectedPlayers);
                players.add(newPlayer);
                out.writeUTF("Connected to server, waiting to start.");

                if (connectedPlayers >= MIN_PLAYERS) {
                    out.writeUTF("You're the host, press /start to begin the game.");
                    String message = in.readUTF();
                    if (message.equalsIgnoreCase("/start")) {
                        gameStarted = true;
                        beginGame();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error starting the server: " + e.getMessage());
        }
    }

    private void beginGame() {
        System.out.println("The game has begun with " + connectedPlayers + " players.");
        for (Socket socket : clientSockets) {
            try {
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("The game has begun!");
            } catch (Exception e) {
                System.out.println("Error initializing the game: " + e);
            }
        }
    }

    public String getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }

    public int[] getPositions() {
        return players.stream().mapToInt(Player::getPosition).toArray();
    }

    public void movePlayer(int playerId, int steps) {
        if (playerId >= 0 && playerId < players.size()) {
            players.get(playerId).move();
            System.out.println(players.get(playerId).getName() + " moved to " + players.get(playerId).getPosition());
        }
    }

    public boolean isGameEnded() {
        return players.stream().anyMatch(player -> player.getPosition() >= WINNING_POSITION);
    }

    public void nextTurn() {
        if (!isGameEnded()) {
            currentTurn = (currentTurn + 1) % players.size();
        }
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public int[] getFinalPositions() {
        return getPositions();
    }
}
