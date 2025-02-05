package com.example.triviant.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;

    public GameClient (String serverAdress, int port){
        try {
            socket = new Socket(serverAdress, port);
            in = new DataInputStream( socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);

            System.out.println("Connected to server!");
            startGameLoop();
        } catch (IOException e){
            System.out.println("Error connecting server: " + e.getMessage());
        }
    }

    private void startGameLoop() {
        try {
            while (true){
                String serverMessage = in.readUTF();
                System.out.println(serverMessage);

                if (serverMessage.contains("Your turn")){
                    System.out.print("Press ENTER to roll the dice...");
                    scanner.nextLine();
                    out.writeUTF("/roll");
                    out.flush();
                }

                if (serverMessage.contains("Game Over")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Connection lost: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {
        try {
            if (socket != null) socket.close();
            if (in != null) in.close();
            if (out != null) out.close();
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new GameClient("localhost", 4040);
    }

}
