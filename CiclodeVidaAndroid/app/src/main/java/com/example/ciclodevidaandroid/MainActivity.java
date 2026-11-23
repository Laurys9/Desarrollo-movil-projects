package com.example.ciclodevidaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // La actividad esta creada.
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();

        // Backend y logica del btnClick
        btnOpen = findViewById(R.id.btnClick);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // La actividad se muestra y esta a punto de hacerse visible.
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // La actividad se ha vuelto visible (donde se "reanuda").
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // La actividad esta a punto de ser detenida al momento de enfocarse en otra actividad.
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // La actividad ya no es visible (ahora esta "detenida").
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // La actividad está a punto de ser visible otra vez, es decir, está a punto de reiniciarse, reiniciar tareas o recursos.
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // La actividad esta a punto de ser destruida, es cuando cierras la aplicación.
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
    }

}

