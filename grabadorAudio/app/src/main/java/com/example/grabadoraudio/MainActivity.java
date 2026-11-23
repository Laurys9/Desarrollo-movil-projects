package com.example.grabadoraudio;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.Manifest;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private String outputFile; // Ruta del archivo de audio
    private MediaRecorder miGrabador; // Grabador de audio


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat .requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
        }
    }

    // Métodos para grabar, detener y reproducir audio

    // Método para iniciar la grabación
    public void Grabar(View view) {
        outputFile = getExternalFilesDir(null).getAbsolutePath() + "/Grabacion.3gp";
        miGrabador = new MediaRecorder();
        miGrabador.setAudioSource(MediaRecorder.AudioSource.MIC);
        miGrabador.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        miGrabador.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        miGrabador.setOutputFile(outputFile);

        try {
            miGrabador.prepare();
            miGrabador.start();
            Toast.makeText(this, "Grabación iniciada", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al iniciar la grabación", Toast.LENGTH_LONG).show();
        }
    }

    public void Detener(View view) {
        if (miGrabador != null) {
            try {
                miGrabador.stop();
                miGrabador.release();
                miGrabador = null;
                Toast.makeText(this, "Grabación detenida y guardada", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Error al detener la grabación", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void reproducir(View view) {
        if (outputFile == null) {
            Toast.makeText(this, "No hay grabación para reproducir", Toast.LENGTH_LONG).show();
            return;
        }

        MediaPlayer m = new MediaPlayer();
        try {
            m.setDataSource(outputFile);
            m.prepare();
            m.start();
            Toast.makeText(this, "Reproduciendo audio", Toast.LENGTH_LONG).show();

            m.setOnCompletionListener(mp -> {
                mp.release();
                Toast.makeText(this, "Reproducción finalizada", Toast.LENGTH_LONG).show();
            });
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al reproducir el audio", Toast.LENGTH_LONG).show();
        }
    }




}