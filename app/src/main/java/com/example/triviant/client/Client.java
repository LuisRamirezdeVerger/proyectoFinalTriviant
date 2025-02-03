package com.example.triviant.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String serverAddress;
    private int serverPort;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;

    public Client(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void start() {
        try {
            socket = new Socket(serverAddress, serverPort);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);

            System.out.println("Connected to the server.");

            // Thread for server messages
            new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        System.out.println("Server: " + message);
                    }
                } catch (IOException e) {
                    System.out.println("Connection lost. Exiting...");
                    System.exit(0); // Close the program if teh server is down
                }
            }).start();

            // To send messages to server
            while (true) {
                String userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("/exit")) {
                    System.out.println("Disconnecting...");
                    break; //Get out and close connection
                }

                out.writeUTF(userInput);
                out.flush();
            }

        } catch (IOException e) {
            System.out.println("Could not connect to server: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {
        try {
            if (scanner != null) scanner.close();
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 4040);
        client.start();
    }
}
