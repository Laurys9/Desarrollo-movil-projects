package com.example.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    TextView tv1;
    Switch s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        s = findViewById(R.id.switch1);
    }

    // FUNCION PARA SALIR DE LA APLICACION Y ESTA SE DETENGA ACORDE AL CICLO DE VIDA DE ANDROID
    protected void onStop() {
        super.onStop();
        if (mp!=null)
        {
            mp.release();
            mp=null;
        }
    }

    // METODO O FUNCION DEL BTN INICIAR REPRODUCCION
    public void Iniciar(View view){
        if (mp!=null)
            mp.release();
        mp=MediaPlayer.create(this, R.raw.chopin);
        if(s.isChecked())
            mp.setLooping(true);
        mp.start();
        tv1.setText("Estado: Reproduciendo");
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                tv1.setText("Estado: detenido");
            }
        });
    }

    // METODO O FUNCION DEL BTN PAUSAR / DETENER
    public void Pausar(View view){
        if (mp!=null && mp.isPlaying()){
            mp.pause();
            tv1.setText("Estado: Pausado");
        }
    }

    // METODO O FUNCION DEL BTN REANUDAR
    public void Reanudar(View view){
        if (mp!=null && !mp.isPlaying()){
            mp.start();
            tv1.setText("Estado: Reanudando reproduccion");
        }
    }

    // METODO O FUNCION DEL BTN SALTAR 5 SEGUNDOS
    public void Avanzar5(View view){
        if (mp!=null){
            int posicion = mp.getCurrentPosition();
            mp.seekTo(posicion+5000);
        }
    }

    // METODO O FUNCION REPRODUCCION CIRCULAR
    public void reproducirCircular(View view){
        if (s.isChecked())
            mp.setLooping(true);
        else
            mp.setLooping(false);
    }

}