package com.example.calculadoraapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText num1Edit;
    private EditText num2Edit;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1Edit = findViewById(R.id.num1Edit);
        num2Edit = findViewById(R.id.num2Edit);
        txtResultado = findViewById(R.id.txtResultado);
    }

    public void Sumar(View view) {
        int val1 = Integer.parseInt(num1Edit.getText().toString());
        int val2 = Integer.parseInt(num2Edit.getText().toString());

        txtResultado.setText(String.valueOf(val1 + val2));
    }

    public void Restar(View view) {
        int val1 = Integer.parseInt(num1Edit.getText().toString());
        int val2 = Integer.parseInt(num2Edit.getText().toString());

        txtResultado.setText(String.valueOf(val1 - val2));
    }

    public void Multiplicar(View view) {
        int val1 = Integer.parseInt(num1Edit.getText().toString());
        int val2 = Integer.parseInt(num2Edit.getText().toString());

        txtResultado.setText(String.valueOf(val1 * val2));
    }

    public void Dividir(View view) {
        int val1 = Integer.parseInt(num1Edit.getText().toString());
        int val2 = Integer.parseInt(num2Edit.getText().toString());

        txtResultado.setText(String.valueOf(val1 / val2));
    }

}