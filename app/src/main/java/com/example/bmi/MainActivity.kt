package com.example.bmi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculate(view: View?) {
        val weightInput = findViewById<EditText?>(R.id.weight)
        val heightInput = findViewById<EditText?>(R.id.height)
        val resultOutput = findViewById<TextView?>(R.id.result)
        val ageInput = findViewById<EditText?>(R.id.age)
        val age: Int = ageInput?.text.toString().toInt()
        val radioGroup = findViewById<RadioGroup?>(R.id.radioSex)
        val selectedId = radioGroup?.checkedRadioButtonId
        val radioButton = findViewById<RadioButton?>(selectedId!!)
        try {
            if (weightInput != null && heightInput != null && resultOutput != null) {
                val i = Intent(this@MainActivity, FoodActivity::class.java)
                i.putExtra("weight", weightInput.text.toString())
                i.putExtra("height", heightInput.text.toString())
                i.putExtra("age", age.toString())
                if (radioButton != null) {
                    i.putExtra("sex", radioButton.text)
                }
                startActivity(i)
            } else {
                throw NullPointerException()
            }
        } catch (e: Exception) {
            Log.e("error", e.message.toString())
            val sv = findViewById<ScrollView?>(R.id.scrollView)
            sv?.scrollTo(0, sv.bottom)
            resultOutput?.text = "Incorrect data provided"
        }
    }
}