package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView questionText;
    private RadioGroup answerGroup;
    private Button submitButton;
    private TextView finalScoreText;

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicjalizacja elementów UI
        questionText = findViewById(R.id.question_text);
        answerGroup = findViewById(R.id.answer_group);
        submitButton = findViewById(R.id.submit_button);
        finalScoreText = findViewById(R.id.final_score);

        // Pobranie pytań
        questions = getQuestions();
        showNextQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    // Wyświetlenie następnego pytania
    private void showNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionText.setText(currentQuestion.getQuestionText());

            // Zresetowanie grupy odpowiedzi
            answerGroup.clearCheck();
            ((RadioButton) answerGroup.getChildAt(0)).setText(currentQuestion.getAnswers()[0]);
            ((RadioButton) answerGroup.getChildAt(1)).setText(currentQuestion.getAnswers()[1]);
            ((RadioButton) answerGroup.getChildAt(2)).setText(currentQuestion.getAnswers()[2]);
            ((RadioButton) answerGroup.getChildAt(3)).setText(currentQuestion.getAnswers()[3]);
        } else {
            endQuiz();
        }
    }

    // Sprawdzanie odpowiedzi i aktualizacja wyniku
    private void checkAnswer() {
        int selectedAnswerIndex = answerGroup.indexOfChild(findViewById(answerGroup.getCheckedRadioButtonId()));
        if (selectedAnswerIndex == questions.get(currentQuestionIndex).getCorrectAnswerIndex()) {
            score++;
        }

        currentQuestionIndex++;
        showNextQuestion();
    }

    // Zakończenie quizu i wyświetlenie wyniku
    private void endQuiz() {
        questionText.setVisibility(View.GONE);
        answerGroup.setVisibility(View.GONE);
        submitButton.setVisibility(View.GONE);
        finalScoreText.setVisibility(View.VISIBLE);

        String result = "Twój wynik: " + score + "/" + questions.size();
        finalScoreText.setText(result);
    }

    // Tworzenie listy pytań
    private List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Ile wynosi 2+2?", new String[]{"3", "4", "5", "6"}, 1));
        questions.add(new Question("Jaki jest największy ocean na świecie?", new String[]{"Atlantycki", "Spokojny", "Arktyczny", "Indyjski"}, 1));
        questions.add(new Question("Stolicą Polski jest:", new String[]{"Warszawa", "Berlin", "Moskwa", "Praga"}, 0));
        questions.add(new Question("Najwyższa góra świata to:", new String[]{"K2", "Everest", "Makalu", "Lhotse"}, 1));
        questions.add(new Question("Jaki gaz dominuje w atmosferze?", new String[]{"Tlen", "Wodór", "Azot", "Hel"}, 2));
        questions.add(new Question("Ile kontynentów istnieje?", new String[]{"5", "6", "7", "8"}, 2));
        questions.add(new Question("Który pierwiastek ma symbol 'O'?", new String[]{"Tlen", "Wodór", "Złoto", "Azot"}, 0));
        questions.add(new Question("Która planeta jest najbliżej Słońca?", new String[]{"Mars", "Wenus", "Ziemia", "Merkury"}, 3));
        questions.add(new Question("Jaka jednostka służy do mierzenia prądu?", new String[]{"Volt", "Ohm", "Amper", "Herc"}, 2));
        questions.add(new Question("W jakim roku zakończyła się II wojna światowa?", new String[]{"1942", "1944", "1945", "1946"}, 2));
        return questions;
    }
}
