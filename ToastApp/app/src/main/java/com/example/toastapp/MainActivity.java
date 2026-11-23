package com.example.toastapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);

        num = (int) (Math.random()*100101);
        Toast.makeText(this, ""+num, Toast.LENGTH_LONG).show();

    }

    public void compararResultados(View view){
        int valorIngresado;

        valorIngresado=Integer.parseInt(et1.getText().toString());

        if (valorIngresado == num) {
            Toast.makeText(this, "El numero que ha ingresado es CORRECTO", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "El numero ingresado es INCORRRECTO", Toast.LENGTH_LONG).show();
        }
    }


}