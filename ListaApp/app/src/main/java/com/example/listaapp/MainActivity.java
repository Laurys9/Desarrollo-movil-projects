package com.example.listaapp;

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

    // Declarando la lista de arreglos(Arrays) usados en la lista de lenguajes de programacion
    private String[] lenguajes = {
            "Python",
            "C#",
            "JavaScript",
            "C++",
            "PHP",
            "Swift",
            "Java",
            "Kotlin",
            "R"
    };

    private String[] conceptos = {
                " es un lenguaje de programación interpretado, de alto nivel y propósito general, conocido por su sintaxis sencilla y su enfoque en la legibilidad del código.",
                " es un lenguaje de programación orientado a objetos de Microsoft para aplicaciones en la plataforma .NET.",
                " es un lenguaje de programación de alto nivel, esencial para el desarrollo web, que permite crear interactividad en las páginas del lado del cliente.",
                " es un lenguaje de programación de propósito general, orientado a objetos, que extiende a C con características avanzadas para desarrollo de software de alto rendimiento.",
                " es un lenguaje de programación del lado del servidor, ampliamente usado para el desarrollo web y la creación de contenido dinámico.",
                " es un lenguaje de programación de Apple, optimizado para desarrollar aplicaciones en iOS, macOS, watchOS y tvOS, conocido por su rapidez y seguridad.",
                " es un lenguaje de programación de propósito general, orientado a objetos y multiplataforma, ampliamente utilizado en desarrollo web, móvil y empresarial.",
                " es un lenguaje de programación moderno, interoperable con Java y enfocado en la simplicidad y seguridad, principalmente utilizado para desarrollo en Android.",
                " es un lenguaje de programación y entorno de software para el análisis estadístico y la visualización de datos, ampliamente utilizado en la investigación y la ciencia de datos."
    };

  // Creando objetos
  private TextView tvConcepto;
  private ListView listLenguaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencia de objetos con los controles
        tvConcepto = (TextView)findViewById(R.id.textView);
        listLenguaje = (ListView)findViewById(R.id.list1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lenguajes);
        listLenguaje.setAdapter(adapter);

        // Funcion onItemclick donde al momento de presionar un item muestre el lenguaje seleccionado y su concepto
        listLenguaje.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvConcepto. setText( listLenguaje.getItemAtPosition(i)+conceptos[i]);

                String opcSelection=(String)listLenguaje.getAdapter().getItem(i);
                Toast.makeText(getApplicationContext(),opcSelection,Toast.LENGTH_SHORT).show();
            }
        });


    }
}