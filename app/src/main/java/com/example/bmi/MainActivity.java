package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
        TextView kcalOutput = findViewById(R.id.kcal);
        float weight = 0;
        float height = 0;
        String resultText;
        try {
            weight = Float.parseFloat(weightInput.getText().toString());
            height = Float.parseFloat(heightInput.getText().toString()) / 100;
            float bmi = weight / (height * height);
            if (bmi > 0 && bmi <= 18.5) {
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

        EditText ageInput = findViewById(R.id.age);
        int age = Integer.parseInt(ageInput.getText().toString());
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioSex);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);

        double kcal = 0;
        if (radioButton.getText().equals(Gender.Male.toString())) {
            kcal = 66.4730 + 13.7516 * weight + 5.0033 * height - 6.7550 * age;
        } else if (radioButton.getText().equals(Gender.Female.toString())) {
            kcal = 655.0955 + 9.5634 * weight + 1.8496 * height - 4.6756 * age;
        }
        resultOutput.setText(resultText);
        kcalOutput.setText(String.format("%s kcal", kcal));
    }
}