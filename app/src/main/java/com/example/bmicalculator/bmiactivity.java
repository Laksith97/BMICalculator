package com.example.bmicalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class bmiactivity extends AppCompatActivity {

    android.widget.Button recalculatebmi;

    TextView bmidisplay,bmicategory,gender;
    Intent intent;
    ImageView imageview;
    String bmi;
    float intbmi;

    String height;
    String weight;
    float intheight,intweight;
    RelativeLayout background;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        SpannableString spannableString = new SpannableString("Your Title");
        spannableString.setSpan(new ForegroundColorSpan(Color.WHITE), 0, spannableString.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        intent=getIntent();
        String gender = intent.getStringExtra("gender");

        bmidisplay=findViewById(R.id.bmidisplay);
        bmicategory = findViewById(R.id.bmicategory);
        background=findViewById(R.id.contentlayout);
        imageview=findViewById(R.id.imageview);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;

        intbmi=intweight/(intheight*intheight);

        String formattedBMI = String.format("%.2f", intbmi);
        bmidisplay.setText(formattedBMI);

        TextView genderDisplay = findViewById(R.id.genderdisplay);

        if (gender != null && !gender.isEmpty()) {
            genderDisplay.setText(gender);
        }

        if(intbmi<16)
        {
            bmicategory.setText("Severe Thinness");
            background.setBackgroundColor(Color.RED);
            imageview.setImageResource(R.drawable.crosss);
        }
        else if(intbmi<16.9 && intbmi>16)
        {
            bmicategory.setText("Moderate Thinness");
            background.setBackgroundColor(Color.RED);
            imageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi<18.4 && intbmi>17)
        {
            bmicategory.setText("Mild Thinness");
            background.setBackgroundColor(Color.RED);
            imageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi<25 && intbmi>18.4 )
        {
            bmicategory.setText("Normal");
            background.setBackgroundColor(Color.MAGENTA);
            imageview.setImageResource(R.drawable.ok);
        }
        else if(intbmi <29.4 && intbmi>25)
        {
            bmicategory.setText("Overweight");
            background.setBackgroundColor(Color.RED);
            imageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi<34.9 && intbmi>30)
        {
            bmicategory.setText("Obese Class I");
            background.setBackgroundColor(Color.YELLOW);
            imageview.setImageResource(R.drawable.warning);
        }
        else
        {
            bmicategory.setText("Obese Class II");
            background.setBackgroundColor(Color.RED);
            imageview.setImageResource(R.drawable.crosss);
        }

        recalculatebmi = findViewById(R.id.recalculatebmi);

        recalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bmiactivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        });
    }

    public void showExerciseRecommendations(View view) {
        Intent intent = new Intent(bmiactivity.this, ExerciseRecommendationActivity.class);
        intent.putExtra("bmiCategory", bmicategory.getText().toString());
        startActivity(intent);
        finish();
    }
}
