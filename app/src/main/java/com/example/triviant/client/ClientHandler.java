package com.example.triviant.client;

import com.example.triviant.Player;
import com.example.triviant.server.Server;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler extends Thread {
    private final Server server;
    private final Socket socket;
    private final int playerId;
    private final Player player;
    private final DataInputStream in;
    private final DataOutputStream out;

    public ClientHandler(Server server, Socket socket, int playerId, Player player) throws IOException {
        this.server = server;
        this.socket = socket;
        this.playerId = playerId;
        this.player = player;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            // Enviar lista de jugadores al cliente
            out.writeUTF(server.getPlayerNames());
            out.flush();

            while (!server.isGameEnded()) {
                if (server.getCurrentTurn() == playerId) {
                    out.writeUTF("Your turn! Roll the dice.");
                    int diceResult = in.readInt(); // Esperamos un número del cliente
                    server.movePlayer(playerId, diceResult);

                    // Enviar posiciones actualizadas a todos los clientes
                    int[] positions = server.getPositions();
                    for (int pos : positions) {
                        out.writeInt(pos);
                    }
                    out.flush();

                    if (server.isGameEnded()) {
                        break;
                    }
                    server.nextTurn();
                }
                Thread.sleep(500);
            }

            // Notificar fin de partida
            out.writeUTF("Game over!");
            out.flush();
        } catch (IOException | InterruptedException e) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
