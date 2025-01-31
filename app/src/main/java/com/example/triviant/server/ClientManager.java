package com.example.triviant.server;

import com.example.triviant.Player;

import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientManager extends Thread {

    private Server server;
    private Socket socket;
    private int playerId;
    private Player player;

    public ClientManager( Server server, Socket socket, int playerId, Player player){

        this.server = server;
        this.socket = socket;
        this.playerId = playerId;
        this.player = player;
    }

    @Override
    public void run(){
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())){
            // We send list of players
            String names = player.getName();
            out.writeUTF(names);
            out.flush();


        } catch (Exception e){
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
