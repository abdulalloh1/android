package com.example.dtmtesting;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dtmtesting.R;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button submitAnswerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        radioGroup = findViewById(R.id.radioGroup);
        submitAnswerButton = findViewById(R.id.submitAnswerButton);

        submitAnswerButton.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);

            if (selectedId == -1) {
                Toast.makeText(MainActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
            } else {
                String selectedAnswer = radioButton.getText().toString();
                checkAnswer(selectedAnswer);
            }
        });
    }

    private void checkAnswer(String answer) {
        if ("Paris".equals(answer)) {
            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Wrong answer, the correct answer is Paris", Toast.LENGTH_SHORT).show();
        }
    }
}
