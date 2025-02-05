package com.example.triviant.server;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientManager extends Thread {
    private Server server;
    private Socket socket;
    private int playerId;
    //private Player player;
    private Random random;

    public ClientManager(Server server, Socket socket, int playerId) {
        this.server = server;
        this.socket = socket;
        this.playerId = playerId;
        //this.player = player;
        this.random = new Random();
    }

    @Override
    public void run() {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            // Send players list to client
            out.writeUTF(server.getPlayerNames());
            out.flush();

            while (!server.isGameEnded()) {
                if (server.getCurrentTurn() == playerId) {
                    // Simulate dice roll and move the player
                    int steps = rollDice();
                    server.movePlayer(playerId, steps);

                    // Enviar posiciones actualizadas
                    int[] positions = server.getPositions();
                    for (int pos : positions) {
                        out.writeInt(pos);
                    }
                    out.writeInt(0); // 0 => game is running
                    out.flush();

                    if (server.isGameEnded()) {
                        break;
                    }

                    // Next player
                    server.nextTurn();
                }
                Thread.sleep(500);
            }

            // Fin de la partida: enviar posiciones finales
            int[] finalPositions = server.getFinalPositions();
            for (int pos : finalPositions) {
                out.writeInt(pos);
            }
            out.writeInt(-1); // -1 => fin de partida
            out.flush();

            System.out.println("Player " + playerId + " has sent final positions.");

        } catch (Exception e) {
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private int rollDice() {
        return random.nextInt(6) + 1; // Simula un dado de 6 caras (1-6)
    }
}
