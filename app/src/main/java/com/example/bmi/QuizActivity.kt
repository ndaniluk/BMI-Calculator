package com.example.bmi

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
    }

    fun sendAnswers(view: View?) {
        var result = 0

        //q1
        val q1aButton = findViewById<RadioButton?>(R.id.q1a4)
        if (q1aButton != null) {
            if (q1aButton.isChecked) {
                result++
            }
        }

        //q2
        val q2aButton = findViewById<RadioButton?>(R.id.q2a1)
        if (q2aButton != null) {
            if (q2aButton.isChecked) {
                result++
            }
        }

        //q3
        val q3aButton = findViewById<RadioButton?>(R.id.q3a2)
        if (q3aButton != null) {
            if (q3aButton.isChecked) {
                result++
            }
        }

        //q4
        val q4aButton = findViewById<RadioButton?>(R.id.q4a2)
        if (q4aButton != null) {
            if (q4aButton.isChecked) {
                result++
            }
        }

        //q5
        val q5aButton = findViewById<RadioButton?>(R.id.q5a2)
        if (q5aButton != null) {
            if (q5aButton.isChecked) {
                result++
            }
        }

        //q6
        val q6aButton = findViewById<RadioButton?>(R.id.q6a4)
        if (q6aButton != null) {
            if (q6aButton.isChecked) {
                result++
            }
        }
        val resultOutput = findViewById<TextView?>(R.id.result)
        if (resultOutput != null) {
            resultOutput.text = ("$result/6")
        }
    }
}