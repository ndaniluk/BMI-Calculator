package com.example.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        calculate();
    }

    public void calculate() {
        Intent myIntent = getIntent();
        float weight = Float.parseFloat(myIntent.getStringExtra("weight"));
        float height = Float.parseFloat(myIntent.getStringExtra("height"));
        String sex = myIntent.getStringExtra("sex");
        int age = Integer.parseInt(myIntent.getStringExtra("age"));

        String resultText;
        float bmi = weight / ((height / 100) * (height / 100));
        if (bmi > 0 && bmi <= 18.5) {
            resultText = EBMIResult.You_are_underweight.toString();
        } else if (bmi > 18.5 && bmi <= 25) {
            resultText = EBMIResult.Your_weight_is_fine.toString();
        } else if (bmi > 25 && bmi <= 30) {
            resultText = EBMIResult.You_are_overweight.toString();
        } else {
            resultText = EBMIResult.You_are_obese.toString();
        }

        int kcal = 0;
        if (sex.equals(EGender.Male.toString())) {
            kcal = (int) Math.round(66.4730 + 13.7516 * weight + 5.0033 * height - 6.7550 * age);
        } else if (sex.equals(EGender.Female.toString())) {
            kcal = (int) Math.round(655.0955 + 9.5634 * weight + 1.8496 * height - 4.6756 * age);
        }

        TextView resultOutput = findViewById(R.id.result);
        TextView kcalOutput = findViewById(R.id.kcal);
        resultOutput.setText(resultText);
        kcalOutput.setText(String.format("You should eat %s kcal a day", kcal));
        TextView dishOutput = findViewById(R.id.dish);
        dishOutput.setText("No matter what is your BMI, a salad is always a good option :)");
    }
}
