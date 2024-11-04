package com.example.quiz_app;

public class Question {

    private String questionText;  // Treść pytania
    private String[] answers;     // Tablica odpowiedzi
    private int correctAnswerIndex;  // Indeks poprawnej odpowiedzi w tablicy odpowiedzi

    // Konstruktor
    public Question(String questionText, String[] answers, int correctAnswerIndex) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    // Getter do pobierania treści pytania
    public String getQuestionText() {
        return questionText;
    }

    // Getter do pobierania tablicy odpowiedzi
    public String[] getAnswers() {
        return answers;
    }

    // Getter do pobierania indeksu poprawnej odpowiedzi
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}