package com.example.btnnavbarapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CalculateFragment extends Fragment {

    private EditText num1Edit;
    private EditText num2Edit;
    private TextView txtResultado;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);

        // Enlazar las vistas con sus IDs
        num1Edit = view.findViewById(R.id.num1Edit);
        num2Edit = view.findViewById(R.id.num2Edit);
        txtResultado = view.findViewById(R.id.txtResultado);

        // Configurar botones y eventos
        Button btnSumar = view.findViewById(R.id.btnSumar);
        Button btnRestar = view.findViewById(R.id.btnRestar);
        Button btnMultiplicar = view.findViewById(R.id.btnMultiplicar);
        Button btnDividir = view.findViewById(R.id.btnDividir);
        Button btnLimpiar = view.findViewById(R.id.btnSalir);

        btnSumar.setOnClickListener(v -> realizarOperacion("sumar"));
        btnRestar.setOnClickListener(v -> realizarOperacion("restar"));
        btnMultiplicar.setOnClickListener(v -> realizarOperacion("multiplicar"));
        btnDividir.setOnClickListener(v -> realizarOperacion("dividir"));
        btnLimpiar.setOnClickListener(v -> limpiarCampos());

        return view;
    }

    private void realizarOperacion(String operacion) {
        try {
            int val1 = Integer.parseInt(num1Edit.getText().toString());
            int val2 = Integer.parseInt(num2Edit.getText().toString());
            int resultado = 0;

            switch (operacion) {
                case "sumar":
                    resultado = val1 + val2;
                    break;
                case "restar":
                    resultado = val1 - val2;
                    break;
                case "multiplicar":
                    resultado = val1 * val2;
                    break;
                case "dividir":
                    if (val2 == 0) {
                        txtResultado.setText("Error: División entre 0");
                        return;
                    }
                    resultado = val1 / val2;
                    break;
            }
            txtResultado.setText(String.valueOf(resultado));
        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Ingrese números válidos");
        }
    }

    private void limpiarCampos() {
        num1Edit.setText("");
        num2Edit.setText("");
        txtResultado.setText("");
    }

}