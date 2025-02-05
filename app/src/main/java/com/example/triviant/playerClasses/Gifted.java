package com.example.triviant.playerClasses;

import com.example.triviant.GameBoard;
import com.example.triviant.GameUtils;
import com.example.triviant.Player;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Gifted extends Player {
    private final GameBoard gameBoard;

    public Gifted(String name, GameBoard gameBoard){
        super(name);
        this.gameBoard = gameBoard;
    }

    @Override
    public void move() {
        int steps = GameUtils.diceRoll();
        int movement = steps - 1;  // Mueve una casilla menos
        if (movement < 1) movement = 1;  // Nunca menos de 1 casilla

        System.out.println(getName() + " rolled a " + steps + "!");

        // Mueve al superdotado según el valor de los dados
        setPosition(getPosition() + movement);
        System.out.println(getName() + " moved " + movement + " steps!");
    }

    @Override
    public void useAbility(Player other) {
        // Aquí puedes implementar alguna habilidad especial si lo deseas
        System.out.println(getName() + " uses their gifted ability!");
    }

    // Método para responder una pregunta y aplicar la habilidad de "respuesta incorrecta menos"
    public boolean answerQuestion(JSONObject question, int selectedOption) throws JSONException {
        JSONArray correctAnswer = question.getJSONArray("correct_answer");
        JSONArray wrongAnswers = question.getJSONArray("wrong_answers");

        // Convertir JSONArray a lista para poder hacer la comprobación
        boolean isCorrect = false;

        // Comprobamos si la respuesta está en wrongAnswers
        for (int i = 0; i < wrongAnswers.length(); i++) {
            if (wrongAnswers.getInt(i) == selectedOption) {
                // Si la respuesta seleccionada está en wrongAnswers, aplicamos la habilidad
                // El superdotado puede eliminar una respuesta incorrecta
                if (wrongAnswers.length() > 0) {
                    wrongAnswers.remove(0);  // Eliminar la primera respuesta incorrecta
                    System.out.println(getName() + " eliminated an incorrect answer!");
                    isCorrect = true;  // La respuesta es ahora correcta
                }
                break;
            }
        }

        // Si la respuesta está en correctAnswer
        for (int i = 0; i < correctAnswer.length(); i++) {
            if (correctAnswer.getInt(i) == selectedOption) {
                isCorrect = true;
                break;
            }
        }

        return isCorrect;
    }
}
