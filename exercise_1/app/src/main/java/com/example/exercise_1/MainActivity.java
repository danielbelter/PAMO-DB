package com.example.exercise_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button calculateButton;
    private EditText weight, height;
    private TextView bmi, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateButton = findViewById(R.id.caluculateButton);
        weight = findViewById(R.id.weightText);
        height = findViewById(R.id.heightText);
        bmi = findViewById(R.id.bmiText);
        result = findViewById(R.id.scaleText);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double h = Double.parseDouble(height.getText().toString());
                h = h / 100;
                double w = Double.parseDouble(weight.getText().toString());
                double b = w / (h * h);
                bmi.setText(String.valueOf(Math.round(b * 100.0)/ 100.0));
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
}
