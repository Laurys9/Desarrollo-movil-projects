package com.example.loginctrl_edittext;

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

    private EditText etUser, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = (EditText)findViewById(R.id.txt_username);
        etPassword = (EditText)findViewById(R.id.txt_password);

    }

    // Funcion o metodo para la logica del btn_Registrar
    public void Registrar(View view) {

        String username = etUser.getText().toString().trim(); // trim() elimina espacios innecesarios
        String password = etPassword.getText().toString().trim();

        if (username.isEmpty()) { // Verifica si el campo username está vacío
            Toast.makeText(this, "Por favor, ingresa el nombre de usuario", Toast.LENGTH_LONG).show();
        } else if (password.isEmpty()) { // Verifica si el campo password está vacío
            Toast.makeText(this, "Por favor, ingresa una contraseña de usuario", Toast.LENGTH_LONG).show();
        } else { // Si ambos campos están completos
            Toast.makeText(this, "El registro se realizó de forma exitosa", Toast.LENGTH_LONG).show();
        }

    }


}