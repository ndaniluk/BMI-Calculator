package com.example.bmi;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
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
        EditText ageInput = findViewById(R.id.age);
        int age = Integer.parseInt(ageInput.getText().toString());
        RadioGroup radioGroup = findViewById(R.id.radioSex);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        try {
            if (weightInput != null && heightInput != null && resultOutput != null) {

                Intent i = new Intent(MainActivity.this, FoodActivity.class);
                i.putExtra("weight", weightInput.getText().toString());
                i.putExtra("height", heightInput.getText().toString());
                i.putExtra("age", String.valueOf(age));
                i.putExtra("sex", radioButton.getText());
                startActivity(i);

            } else {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            Log.e("error", e.getMessage());
            ScrollView sv = findViewById(R.id.scrollView);
            sv.scrollTo(0, sv.getBottom());
            resultOutput.setText("Incorrect data provided");
        }
    }
}
