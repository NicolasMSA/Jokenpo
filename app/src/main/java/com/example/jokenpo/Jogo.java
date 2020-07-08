package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Jogo extends AppCompatActivity {

    Giroscopio giroscopio;
    View view;
    JogoService jogoService = new JogoService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // o seguinte trecho pode ser omitido
        if (android.os.Build.VERSION.SDK_INT > 11 && android.os.Build.VERSION.SDK_INT < 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.GONE);
        } else if (android.os.Build.VERSION.SDK_INT >= 19) {
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            getWindow().getDecorView().setSystemUiVisibility(uiOptions);
        }

        setContentView(R.layout.activity_jogo);
        getSupportActionBar().hide();
        view = findViewById(R.id.view);
        view.setBackgroundColor(getResources().getColor(android.R.color.black));

        giroscopio= new Giroscopio(this);

        giroscopio.setListener(new Giroscopio.Listener() {
            @Override
            public void onRotation(float rx, float ry, float rz) {
            if(rz > 1.0f){
                jogoService.run();
            }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        giroscopio.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        giroscopio.unregister();
    }
}

// 1-Papel; 2- Pedra; 3-Tesoura;
//U(1) - C(2) -> -1 Usuario
//U(1) - C(3) -> -2 Computador
//U(2) - C(1) ->  1 Computador
//U(2) - C(3) -> -1 Usuario
//U(3) - C(1) ->  2 Usuario
//U(3) - C(2) ->  1 Computador
