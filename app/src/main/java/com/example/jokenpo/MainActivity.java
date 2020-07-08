package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class MainActivity extends AppCompatActivity {
    View view;

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

        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        view = findViewById(R.id.view);

        view.setBackgroundColor(getResources().getColor(android.R.color.black));

    }


        public void proximaTela(View view){

            Intent intent = new Intent(this, Tutorial.class);
            startActivity(intent);
     }

}
