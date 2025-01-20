package com.example.triviant;
import  java.util.*;

//We'll have 60 tiles for now

//Interface for every tile
abstract class Tile{
    protected int position;

    public Tile(int position){
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

    public void setPosition(int newPosition){
        this.position = newPosition;
    }

    //Method for apply an effect on tiles
    public abstract void applyEffect(Player player);

}

//Tile with no effect
class normalTile extends Tile{
    public normalTile(int position){
        super(position);
    }

    @Override
    public void applyEffect(Player player){
        System.out.println("Casilla normal. Sigue el juego.");
    }
}

//Question tile
class QuestionTile extends Tile{
    private List<String> questions;

    public QuestionTile(int position, List<String> questions){
        super(position);
        this.questions = questions;
    }

    @Override
    public void applyEffect(Player player){
        String question = questions.get(new Random().nextInt(questions.size()));
        System.out.println("Pregunta: " + question);
    }
}

//Movement tile
class Movetile extends Tile{
    private int steps;

    public Movetile(int position, int steps){
        super(position);
        this.steps = steps;
    }

    @Override
    public void applyEffect(Player player){
       // player.move(steps);
        System.out.println("Te mueves " + steps + "casillas.");
    }
}

//Lose turn tile
class LoseTurnTile extends Tile{
    public LoseTurnTile(int position){
        super(position);
    }

    @Override
    public void applyEffect (Player player){
        //player.setSkipTurn(true);
        System.out.println("Pierdes el turno. ");
    }
}

class WarpTile extends Tile{
    private int targetPosition;

    public WarpTile(int position, int targetPosition){
        super(position);
        this.targetPosition = targetPosition;
    }

    @Override
    public void applyEffect(Player player){
        player.setPosition(targetPosition);
        System.out.println("Saltas a la casilla " + targetPosition + "!");
    }
}

class StartTile extends Tile{
    public StartTile(){
        super(1);
    }

    @Override
    public void applyEffect(Player player){
        System.out.println("Estás en la casilla de inicio.");
    }
}

class EndTile extends Tile{
    public EndTile(int position){
        super(position);
    }

    @Override
    public void applyEffect(Player player){
        player.setHasFinished(true);
        System.out.println("Has terminado!");
    }
}

class DeathTile extends Tile{
    private int targetPosition;

    public DeathTile(int position, int targetPosition){
        super(position);
        this.targetPosition = targetPosition;
    }

    @Override
    public void applyEffect(Player player){
        player.setPosition(targetPosition);
        System.out.println("Vuelves a la casilla de inicio.");
    }
}