package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextResult;
    private double value1, value2;
    private String currentOperation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the EditText for showing the result
        editTextResult = findViewById(R.id.editTextResult);

        // Button listeners for operations and equal sign
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnEqual = findViewById(R.id.btnEqual);

        btnAdd.setOnClickListener(v -> setOperation("+"));
        btnSubtract.setOnClickListener(v -> setOperation("-"));
        btnMultiply.setOnClickListener(v -> setOperation("*"));
        btnDivide.setOnClickListener(v -> setOperation("/"));

        btnEqual.setOnClickListener(v -> calculateResult());
    }

    // Function to set the operation
    private void setOperation(String operation) {
        String input = editTextResult.getText().toString();
        if (!input.isEmpty()) {
            value1 = Double.parseDouble(input);
            editTextResult.setText("");
            currentOperation = operation;
        }
    }

    // Function to calculate the result based on the operation
    private void calculateResult() {
        String input = editTextResult.getText().toString();
        if (!input.isEmpty()) {
            value2 = Double.parseDouble(input);
            double result = 0;
            switch (currentOperation) {
                case "+":
                    result = value1 + value2;
                    break;
                case "-":
                    result = value1 - value2;
                    break;
                case "*":
                    result = value1 * value2;
                    break;
                case "/":
                    if (value2 != 0) {
                        result = value1 / value2;
                    } else {
                        editTextResult.setText("Error");
                        return;
                    }
                    break;
            }
            editTextResult.setText(String.valueOf(result));
        }
    }
}
