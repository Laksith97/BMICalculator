package com.example.bmicalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

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

//        Objects.requireNonNull(getSupportActionBar()).hide();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

//        getSupportActionBar().setElevation(0);
//        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));

        SpannableString spannableString = new SpannableString("Your Title");
        spannableString.setSpan(new ForegroundColorSpan(Color.WHITE), 0, spannableString.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);


//        // Create a SpannableString with a white title
//        SpannableString spannableString = new SpannableString("Result");
//        spannableString.setSpan(new ForegroundColorSpan(Color.WHITE), 0, spannableString.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        assert actionBar != null;
//        actionBar.setTitle(spannableString);
//
//        // Set the background color
//        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
//        actionBar.setBackgroundDrawable(colorDrawable);

        intent=getIntent();

        bmidisplay=findViewById(R.id.bmidisplay);
        bmicategory = findViewById(R.id.bmicategory);
        gender=findViewById(R.id.genderdisplay);
        background=findViewById(R.id.contentlayout);
        imageview=findViewById(R.id.imageview);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;

        intbmi=intweight/(intheight*intheight);


        bmi=Float.toString(intbmi);


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
            //background.setBackgroundColor(Color.YELLOW);
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
}
