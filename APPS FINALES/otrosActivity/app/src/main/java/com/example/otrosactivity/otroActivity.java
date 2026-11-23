package com.example.otrosactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class otroActivity extends AppCompatActivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otro);

        tv1 = (TextView)findViewById(R.id.tv1);

        String dato = getIntent().getStringExtra("dato");
        tv1.setText("Hola " + dato + " Bienvenid@s");

    }

    public void Volver(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}