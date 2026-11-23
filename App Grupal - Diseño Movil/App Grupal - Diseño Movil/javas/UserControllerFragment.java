package com.example.btnnavbarapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.AlertDialog;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class UserControllerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_controller, container, false);

        CheckBox checkBoxRed = view.findViewById(R.id.checkBox_red);
        CheckBox checkBoxGreen = view.findViewById(R.id.checkBox_green);
        CheckBox checkBoxBlue = view.findViewById(R.id.checkBox_blue);
        CheckBox checkBoxYellow = view.findViewById(R.id.checkBox_yellow);
        CheckBox checkBoxBlack = view.findViewById(R.id.checkBox_black);
        CheckBox checkBoxWhite = view.findViewById(R.id.checkBox_white);
        CheckBox checkBoxOrange = view.findViewById(R.id.checkBox_orange);
        CheckBox checkBoxPurple = view.findViewById(R.id.checkBox_purple);
        CheckBox checkBoxPink = view.findViewById(R.id.checkBox_pink);
        CheckBox checkBoxGray = view.findViewById(R.id.checkBox_gray);

        Button buttonShowColors = view.findViewById(R.id.button_show_colors);

        buttonShowColors.setOnClickListener(v -> {
            StringBuilder selectedColors = new StringBuilder("Colores seleccionados: ");

            // Verifica qué colores fueron seleccionados
            if (checkBoxRed.isChecked()) selectedColors.append("Rojo\n");
            if (checkBoxGreen.isChecked()) selectedColors.append("Verde\n");
            if (checkBoxBlue.isChecked()) selectedColors.append("Azul\n");
            if (checkBoxYellow.isChecked()) selectedColors.append("Amarillo\n");
            if (checkBoxBlack.isChecked()) selectedColors.append("Negro\n");
            if (checkBoxWhite.isChecked()) selectedColors.append("Blanco\n");
            if (checkBoxOrange.isChecked()) selectedColors.append("Naranja\n");
            if (checkBoxPurple.isChecked()) selectedColors.append("Morado\n");
            if (checkBoxPink.isChecked()) selectedColors.append("Rosa\n");
            if (checkBoxGray.isChecked()) selectedColors.append("Gris\n");

            if (selectedColors.length() == 0) {
                Toast.makeText(getContext(), "No se seleccionó ningún color", Toast.LENGTH_SHORT).show();
            } else {

                showSelectedColorsDialog(selectedColors.toString().trim());
            }
        });

        return view;

    }

    private void showSelectedColorsDialog(String selectedColors) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Colores Seleccionados")
                .setMessage(selectedColors)
                .setPositiveButton("OK", null)
                .create()
                .show();
    }
}