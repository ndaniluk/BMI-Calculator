package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view) {
        EditText weightInput = findViewById(R.id.weight);
        EditText heightInput = findViewById(R.id.height);
        TextView resultOutput = findViewById(R.id.result);
        float weight;
        float height;
        String resultText;
        try {
            weight = Float.parseFloat(weightInput.getText().toString());
            height = Float.parseFloat(heightInput.getText().toString()) / 100;
            float bmi = weight / (height * height);
            if (bmi <= 18.5) {
                resultText = "You are underweight";
            } else if (bmi > 18.5 && bmi <= 25) {
                resultText = "Your weight is fine";
            } else if (bmi > 25 && bmi <= 30) {
                resultText = "You are overweight";
            } else {
                resultText = "You are obese";
            }
        } catch (Exception e) {
            resultText = "Incorrect data provided";
        }
        resultOutput.setText(resultText);
    }
}