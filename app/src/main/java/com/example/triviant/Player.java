package com.example.triviant;

public class Player {
    private String icon; // URL o nombre del recurso
    private String status;

    public Player(String icon, String status) {
        this.icon = icon;
        this.status = status;
    }

    public String getIcon() {
        return icon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
