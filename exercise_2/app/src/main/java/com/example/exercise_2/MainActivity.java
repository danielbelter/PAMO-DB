package com.example.exercise_2;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button calculateButton;
    private EditText weight, height, age;
    private TextView bmi, result, welcomeMessage, kebab;


    private TextView mTextMessage;
    private LinearLayout bmiCalculatorLayout, homeLayout, recomendationLayout;
    private RadioGroup radioGroup;
    private ScrollView scrollView;
    private ImageView kebabImg;
    private int gender;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    homeLayout.setVisibility(View.VISIBLE);
                    bmiCalculatorLayout.setVisibility(View.INVISIBLE);
                    recomendationLayout.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_dashboard:
                    homeLayout.setVisibility(View.INVISIBLE);
                    bmiCalculatorLayout.setVisibility(View.VISIBLE);
                    recomendationLayout.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_notifications:
                    homeLayout.setVisibility(View.INVISIBLE);
                    bmiCalculatorLayout.setVisibility(View.INVISIBLE);
                    recomendationLayout.setVisibility(View.VISIBLE);
                    weight = findViewById(R.id.weightText4);
                    height = findViewById(R.id.heightText4);
                    result = findViewById(R.id.recom_result);
                    age = findViewById(R.id.heightText5);
                    scrollView.setVisibility(View.INVISIBLE);
                    calculateButton = calculateButton.findViewById(R.id.caluculateButton);
                    radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            View radioButton = radioGroup.findViewById(checkedId);
                            int index = radioGroup.indexOfChild(radioButton);
                            switch (index) {
                                case 0:
                                    gender = 0;
                                    kebab.setVisibility(View.INVISIBLE);
                                    kebabImg.setVisibility(View.INVISIBLE);
                                    break;
                                case 1:
                                    gender = 1;
                                    kebab.setVisibility(View.VISIBLE);
                                    kebabImg.setVisibility(View.VISIBLE);
                                    break;
                            }
                        }
                    });
                    findViewById(R.id.recom_calc_button).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            double weightVal = Float.parseFloat(weight.getText().toString());
                            double heightVal = Float.parseFloat(height.getText().toString());
                            double ageVal = Float.parseFloat(age.getText().toString());

                            double resultVal = calculate(weightVal, heightVal, ageVal);

                            result.setText(resultVal + " kcal");
                            scrollView.setVisibility(View.VISIBLE);
                        }

                    });
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        homeLayout = findViewById(R.id.homeLayout);
        recomendationLayout = findViewById(R.id.recomendation_layout);
        bmiCalculatorLayout = findViewById(R.id.bmi_calculaltor_layout);
        homeLayout.setVisibility(View.VISIBLE);
        bmiCalculatorLayout.setVisibility(View.INVISIBLE);
        recomendationLayout.setVisibility(View.INVISIBLE);
        kebab = findViewById(R.id.recipe4);
        kebabImg = findViewById(R.id.imageView4);


        welcomeMessage = findViewById(R.id.welcome_message_textView);
        calculateButton = findViewById(R.id.caluculateButton);
        weight = findViewById(R.id.weightText);
        height = findViewById(R.id.heightText);
        bmi = findViewById(R.id.bmiText);
        result = findViewById(R.id.scaleText);
        scrollView = findViewById(R.id.scrollview);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double h = Double.parseDouble(height.getText().toString());
                h = h / 100;
                double w = Double.parseDouble(weight.getText().toString());
                double b = w / (h * h);
                bmi.setText(String.valueOf(Math.round(b * 100.0) / 100.0));
                if (b >= 25.0) {
                    result.setText("Nadwaga");
                } else if (b > 18.5) {
                    result.setText("W normie");
                } else {
                    result.setText("Niedowaga");
                }
            }
        });

    }

    private double calculate(double weight, double height, double age) {
        double val = 0;
        if (gender == 0) {
            val = (10 * weight) + (height * 6.25) - (5 * age) - 161;
        } else if (gender == 1) {
            val = ((10 * weight) + (height * 6.25) - (5 * age) + 5);
        }
        return val;
    }
}
