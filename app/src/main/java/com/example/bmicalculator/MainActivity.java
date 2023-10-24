package com.example.bmicalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button calculatebmi;

    TextView currentheight;
    TextView currentweight,currentage;
    ImageView incrementage,decrementage,incrementweight,decrementweight;
    SeekBar seekbarforheight;
    RelativeLayout male,female;


    int intweight=55;
    int intage=22;
    int currentprogress;
    String intprogress="170";
    String typerofuser="0";
    String weight2="55";
    String age2="22";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportActionBar().hide();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }



        calculatebmi = findViewById(R.id.calculatebmi);

        currentage=findViewById(R.id.currentage);
        currentweight=findViewById(R.id.currentweight);
        currentheight=findViewById(R.id.currentheight);
        incrementage=findViewById(R.id.incrementage);
        decrementage=findViewById(R.id.decrementage);
        incrementweight=findViewById(R.id.incrementweight);
        decrementweight=findViewById(R.id.decrementweight);
        calculatebmi=findViewById(R.id.calculatebmi);
        seekbarforheight=findViewById(R.id.seekbarforheight);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);


        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typerofuser="Male";

            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typerofuser="Female";
            }
        });


        seekbarforheight.setMax(300);
        seekbarforheight.setProgress(170);
        seekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                currentprogress=progress;
                intprogress=String.valueOf(currentprogress);
                currentheight.setText(intprogress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });


        incrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight+1;
                weight2=String.valueOf(intweight);
                currentweight.setText(weight2);
            }
        });

        decrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intweight=intweight-1;
                weight2=String.valueOf(intweight);
                currentweight.setText(weight2);
            }
        });


        incrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage+1;
                age2=String.valueOf(intage);
                currentage.setText(age2);
            }
        });

        decrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage-1;
                age2=String.valueOf(intage);
                currentage.setText(age2);
            }
        });



        calculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(typerofuser.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"Select Your Gender First",Toast.LENGTH_SHORT).show();
                }

                else if(intprogress.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"Select Your Height First",Toast.LENGTH_SHORT).show();
                }

                else if(intage==0 || intage<0)
                {
                    Toast.makeText(getApplicationContext(),"Age is Incorrect",Toast.LENGTH_SHORT).show();
                }

                else if(intweight==0|| intweight<0)
                {
                    Toast.makeText(getApplicationContext(),"Weight Is Incorrect",Toast.LENGTH_SHORT).show();
                }

                else {

                    Intent intent = new Intent(MainActivity.this, bmiactivity.class);
                    intent.putExtra("gender", typerofuser);
                    intent.putExtra("height", intprogress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);

                    startActivity(intent);

                }

            }
        });

    }
}
