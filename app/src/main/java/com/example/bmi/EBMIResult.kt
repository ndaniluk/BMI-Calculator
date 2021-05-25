package com.example.bmi

enum class EBMIResult {
    You_are_underweight, Your_weight_is_fine, You_are_overweight, You_are_obese;

    override fun toString(): String {
        return super.toString().replace("_", " ")
    }
}