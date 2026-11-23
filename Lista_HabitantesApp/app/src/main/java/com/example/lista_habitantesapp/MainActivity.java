package com.example.lista_habitantesapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String[] paises = {
            "Argentina ",
            "Chile ",
            "Paraguay ",
            "Bolivia ",
            "Peru ",
            "Ecuador ",
            "Brasil ",
            "Colombia ",
            "Venezuela ",
            "Uruguay "
    };

    private String[] habitantes = {
            "40000000",
            "17000000",
            "6500000",
            "10000000",
            "30000000",
            "14000000",
            "183000000",
            "44000000",
            "29000000",
            "3500000"
    };


    // Creando objetos
    private TextView tvHabitantes;
    private ListView listPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencia de objetos con los controles
        tvHabitantes = (TextView)findViewById(R.id.textView);
        listPaises = (ListView)findViewById(R.id.list1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, paises);
        listPaises.setAdapter(adapter);

        // Funcion onItemclick donde al momento de presionar un item muestre el pais seleccionado y numero de habitantes
        listPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Formato del texto a mostrar en TextView y Toast
                String mensaje = paises[i] + " tiene " + habitantes[i] + " habitantes";

                // Mostrar en TextView
                tvHabitantes.setText(mensaje);

                // Mostrar en Toast
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });


    }
}