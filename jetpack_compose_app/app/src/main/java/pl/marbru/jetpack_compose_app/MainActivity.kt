package pl.marbru.jetpack_compose_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import pl.marbru.jetpack_compose_app.ui.theme.Jetpack_compose_appTheme

// Data model for a question
data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_compose_appTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuizApp()
                }
            }
        }
    }
}

@Composable
fun QuizApp() {
    val questions = listOf(
        Question("What is the capital of France?", listOf("Paris", "Berlin", "Madrid", "Rome"), 0),
        Question("What is 2 + 2?", listOf("3", "4", "5", "6"), 1),
        Question("Which planet is closest to the Sun?", listOf("Earth", "Venus", "Mercury", "Mars"), 2),
        Question("What is the largest ocean on Earth?", listOf("Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"), 3),
        Question("What is the boiling point of water?", listOf("90°C", "100°C", "110°C", "120°C"), 1),
        Question("Who painted the Mona Lisa?", listOf("Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet"), 2),
        Question("What is the square root of 64?", listOf("6", "8", "10", "12"), 1)
    )

    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedOption by remember { mutableStateOf(-1) }
    var score by remember { mutableStateOf(0) }
    var isFinished by remember { mutableStateOf(false) }

    val progress = (currentQuestionIndex + 1).toFloat() / questions.size

    if (isFinished) {
        // Show result
        ResultScreen(score = score, totalQuestions = questions.size) {
            // Reset quiz when Restart is clicked
            score = 0
            currentQuestionIndex = 0
            selectedOption = -1
            isFinished = false
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Progress Bar
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                color = Color.Blue
            )

            // Display current question
            Text(
                text = "Question ${currentQuestionIndex + 1}/${questions.size}",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = questions[currentQuestionIndex].text,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Display options
            questions[currentQuestionIndex].options.forEachIndexed { index, option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    RadioButton(
                        selected = selectedOption == index,
                        onClick = { selectedOption = index }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = option, fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Next button
            Button(
                onClick = {
                    if (selectedOption == questions[currentQuestionIndex].correctAnswerIndex) {
                        score++
                    }
                    if (currentQuestionIndex < questions.size - 1) {
                        currentQuestionIndex++
                        selectedOption = -1
                    } else {
                        isFinished = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = if (currentQuestionIndex == questions.size - 1) "Finish Quiz" else "Next")
            }
        }
    }
}

@Composable
fun ResultScreen(score: Int, totalQuestions: Int, onRestart: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Quiz Finished!",
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "You scored $score out of $totalQuestions",
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onRestart,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Restart Quiz")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Jetpack_compose_appTheme {
        QuizApp()
    }
}
