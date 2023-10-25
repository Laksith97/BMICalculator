package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bmicalculator.R;

public class ExerciseRecommendationActivity extends AppCompatActivity {

    TextView exerciseRecommendation;
    android.widget.Button recalculatebmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_recommendation);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setTitle("Exercise Recommendations");
        }

        exerciseRecommendation = findViewById(R.id.exerciseRecommendation);

        // Get the BMI category from the intent
        String bmiCategory = getIntent().getStringExtra("bmiCategory");

        // Display exercise recommendations based on the BMI category
        if (bmiCategory != null) {
            switch (bmiCategory) {
                case "Severe Thinness":
                    exerciseRecommendation.setText(R.string.severe_thinness_exercises);
                    break;
                case "Moderate Thinness":
                    exerciseRecommendation.setText(R.string.moderate_thinness_exercises);
                    break;
                case "Mild Thinness":
                    exerciseRecommendation.setText(R.string.mild_thinness_exercises);
                    break;
                case "Normal":
                    exerciseRecommendation.setText(R.string.normal_exercises);
                    break;
                case "Overweight":
                    exerciseRecommendation.setText(R.string.overweight_exercises);
                    break;
                case "Obese Class I":
                    exerciseRecommendation.setText(R.string.obese_class_i_exercises);
                    break;
                case "Obese Class II":
                    exerciseRecommendation.setText(R.string.obese_class_ii_exercises);
                    break;
            }
        }
    }
    public void recalculateBMI(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
