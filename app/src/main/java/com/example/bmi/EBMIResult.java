package com.example.bmi;

public enum EBMIResult {
    You_are_underweight,
    Your_weight_is_fine,
    You_are_overweight,
    You_are_obese;

    @Override
    public String toString() {
        return super.toString().replace("_", " ");
    }
}
