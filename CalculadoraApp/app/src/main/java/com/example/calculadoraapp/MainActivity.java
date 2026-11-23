package com.example.calculadoraapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Declarando variables para los operandos aritmeticos
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

    // Metodo para la funcion del operador "Sumar"
    public void Sumar(View view) {
        int val1 = Integer.parseInt(num1Edit.getText().toString());
        int val2 = Integer.parseInt(num2Edit.getText().toString());

        txtResultado.setText(String.valueOf(val1 + val2));
    }

    // Metodo para la funcion del operador "Restar"
    public void Restar(View view) {
        int val1 = Integer.parseInt(num1Edit.getText().toString());
        int val2 = Integer.parseInt(num2Edit.getText().toString());

        txtResultado.setText(String.valueOf(val1 - val2));
    }

    // Metodo para la funcion del operador "Multiplicar"
    public void Multiplicar(View view) {
        int val1 = Integer.parseInt(num1Edit.getText().toString());
        int val2 = Integer.parseInt(num2Edit.getText().toString());

        txtResultado.setText(String.valueOf(val1 * val2));
    }

    // Metodo para la funcion del operador "Dividir"
    public void Dividir(View view) {
        int val1 = Integer.parseInt(num1Edit.getText().toString());
        int val2 = Integer.parseInt(num2Edit.getText().toString());

        txtResultado.setText(String.valueOf(val1 / val2));
    }

    // Metodo para "Limpiar" los datos en el resultado
    public void Limpiar(View view) {
        num1Edit.setText("");
        num2Edit.setText("");
        txtResultado.setText("");
    }
}