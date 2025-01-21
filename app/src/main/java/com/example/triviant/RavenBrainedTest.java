package com.example.triviant;
import java.util.*;

public class RavenBrainedTest {
    public static void main(String[] args) {
        String jsonFileName = "board_config.json";
        GameBoard board = new GameBoard(jsonFileName);

        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido a RavenBrained!");
        System.out.print("¿Cuántos jugadores participarán? ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Introduce el nombre del Jugador " + i + ": ");
            String playerName = scanner.nextLine();
            players.add(new Player(playerName));
        }

        boolean gameFinished = false;

        System.out.println("\n--- INICIO DE LA PARTIDA ---");

        // Ciclo del juego
        while (!gameFinished) {
            for (Player player : players) {
                if (player.hasFinished()) continue;

                System.out.println("\nTurno de " + player.getName());
                if (player.isSkipTurn()) {
                    System.out.println(player.getName() + " pierde este turno.");
                    player.setSkipTurn(false);
                    continue;
                }

                System.out.println("Presiona ENTER para tirar el dado...");
                scanner.nextLine();

                int diceRoll = new Random().nextInt(6) + 1;
                System.out.println(player.getName() + " tiró el dado y sacó: " + diceRoll);

                player.move(diceRoll);

                if (player.getPosition() > board.getNumberOfTiles()) {
                    player.setPosition(board.getNumberOfTiles());
                }

                Tile currentTile = board.getTile(player.getPosition());
                System.out.println(player.getName() + " aterrizó en la casilla " + currentTile.getPosition());
                currentTile.applyEffect(player);

                if (player.hasFinished()) {
                    System.out.println(player.getName() + " ha llegado a la casilla final.");
                }
            }

            // Verificar si todos los jugadores han terminado
            gameFinished = players.stream().allMatch(Player::hasFinished);
        }

        System.out.println("\n¡El juego ha terminado! Resultados:");
        for (Player player : players) {
            System.out.println(player.getName() + " terminó en la posición " + player.getPosition());
        }

        scanner.close();
    }
}
