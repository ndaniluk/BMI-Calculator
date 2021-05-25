package com.example.bmi

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bmi.FoodActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import java.util.*
import kotlin.math.roundToInt

class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        calculate()
    }

    fun calculate() {
        val myIntent = intent
        val weight: Float = myIntent.getStringExtra("weight")!!.toFloat()
        val height: Float = myIntent.getStringExtra("height")!!.toFloat()
        val sex = myIntent.getStringExtra("sex")
        val age: Int = myIntent.getStringExtra("age")!!.toInt()
        val dishOutput = findViewById<TextView?>(R.id.dish)
        val resultText: String
        var dishText = ""
        val bmi = weight / (height / 100 * (height / 100))
        if (bmi > 0 && bmi <= 18.5) {
            dishText = "2 egg brown bread sandwich + green chutney + 1 cup milk + 3 cashews + 4 almonds + 2 walnuts"
            resultText = EBMIResult.You_are_underweight.toString()
        } else if (bmi > 18.5 && bmi <= 25) {
            dishText = "Spaghetti Bolognese"
            resultText = EBMIResult.Your_weight_is_fine.toString()
        } else if (bmi > 25 && bmi <= 30) {
            dishText = "Cranberry Asparagus with Pine Nuts"
            resultText = EBMIResult.You_are_overweight.toString()
        } else {
            dishText = "Mediterranean Pasta Salad"
            resultText = EBMIResult.You_are_obese.toString()
        }
        var kcal = 0
        if (sex == EGender.Male.toString()) {
            kcal = (66.4730 + 13.7516 * weight + 5.0033 * height - 6.7550 * age).roundToInt()
        } else if (sex == EGender.Female.toString()) {
            kcal = (655.0955 + 9.5634 * weight + 1.8496 * height - 4.6756 * age).roundToInt()
        }
        val resultOutput = findViewById<TextView?>(R.id.result)
        val kcalOutput = findViewById<TextView?>(R.id.kcal)
        resultOutput.text = resultText
        kcalOutput.text = String.format("You should eat %s kcal a day", kcal)
        dishOutput.text = String.format("Dish for you - %s", dishText)
        val entries: MutableList<PieEntry?> = ArrayList()
        entries.add(PieEntry(22.0f, "USA"))
        entries.add(PieEntry(11.24f, "India"))
        entries.add(PieEntry(9.79f, "Brazil"))
        entries.add(PieEntry(3.73f, "France"))
        entries.add(PieEntry(3.22f, "Russia"))
        entries.add(PieEntry(49.93f, "Others"))
        val set = PieDataSet(entries, "Election Results")
        set.setColors(
                Color.rgb(255, 0, 0),
                Color.rgb(128, 255, 0),
                Color.rgb(0, 255, 128),
                Color.rgb(0, 255, 255),
                Color.rgb(0, 128, 255),
                Color.rgb(0, 0, 255))
        val data = PieData(set)
        val pieChart = findViewById<PieChart?>(R.id.coronaChart)
        pieChart.data = data
        pieChart.description.isEnabled = false
        pieChart.legend.isEnabled = false
        pieChart.invalidate() // refresh
    }

    fun openQuiz(view: View?) {
        val i = Intent(this@FoodActivity, QuizActivity::class.java)
        startActivity(i)
    }
}