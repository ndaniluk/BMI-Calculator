package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }


    public void sendAnswers(View view) {
        int result = 0;

        //q1
        RadioButton q1aButton = findViewById(R.id.q1a4);
        if(q1aButton.isChecked()) {
            result++;
        }

        //q2
        RadioButton q2aButton = findViewById(R.id.q2a1);
        if(q2aButton.isChecked()) {
            result++;
        }

        //q3
        RadioButton q3aButton = findViewById(R.id.q3a2);
        if(q3aButton.isChecked()) {
            result++;
        }

        //q4
        RadioButton q4aButton = findViewById(R.id.q4a2);
        if(q4aButton.isChecked()) {
            result++;
        }

        //q5
        RadioButton q5aButton = findViewById(R.id.q5a2);
        if(q5aButton.isChecked()) {
            result++;
        }

        //q6
        RadioButton q6aButton = findViewById(R.id.q6a4);
        if(q6aButton.isChecked()) {
            result++;
        }

        TextView resultOutput = findViewById(R.id.result);
        resultOutput.setText(String.format("%s/6", result));
    }
}
