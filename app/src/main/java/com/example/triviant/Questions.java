package com.example.triviant;

import java.util.*;

public class Questions {
    private String id;
    private String category;
    private String question;
    private List<String> options;
    private List<Integer> correctAnswer;
    private List<Integer> wrongAnswers;
    private String difficulty;

    //Empty constructor for FireBase
    public Questions(){}

    // Getters & setters
    public String getId() {
        return this.id;
    }

    public void setId(String newId) {
        this.id = newId;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String newCategory) {
        this.category = newCategory;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String newQuestion) {
        this.question = newQuestion;
    }

    public List<String> getOptions() {
        return this.options;
    }

    public void setOptions(List<String> newOptions) {
        this.options = newOptions;
    }

    public List<Integer> getCorrectAnswer() {
        return this.correctAnswer;
    }

    public void setCorrectAnswer(List<Integer> newCorrectAnswer) {
        this.correctAnswer = newCorrectAnswer;
    }

    public List<Integer> getWrongAnswers() {
        return this.wrongAnswers;
    }

    public void setWrongAnswers(List<Integer> newWrongAnswers) {
        this.wrongAnswers = newWrongAnswers;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String newDifficulty) {
        this.difficulty = newDifficulty;
    }
}
