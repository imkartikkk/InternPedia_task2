package com.example.temperatureconverter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button cToF, fToC;
    private TextView result;
    private EditText enterTemp;
    double result0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind views
        cToF = findViewById(R.id.cTof);
        fToC = findViewById(R.id.fToc);
        result = findViewById(R.id.result);
        enterTemp = findViewById(R.id.enterTemp);

        // Celsius to Fahrenheit
        cToF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = enterTemp.getText().toString();
                if (input.isEmpty()) {
                    result.setText("Please enter a value");
                    return;
                }
                try {
                    double temp = Double.parseDouble(input);
                    result0 = (temp * 1.8) + 32;
                    result.setText(String.format("%.2f °F", result0));
                } catch (NumberFormatException e) {
                    result.setText("Invalid Input");
                }
            }
        });

        // Fahrenheit to Celsius
        fToC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = enterTemp.getText().toString();
                if (input.isEmpty()) {
                    result.setText("Please enter a value");
                    return;
                }
                try {
                    double temp = Double.parseDouble(input);
                    result0 = (temp - 32) / 1.8;
                    result.setText(String.format("%.2f °C", result0));
                } catch (NumberFormatException e) {
                    result.setText("Invalid Input");
                }
            }
        });
    }
}
