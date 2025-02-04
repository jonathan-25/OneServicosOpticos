package com.example.oneservicosopticos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.oneservicosopticos.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);




        // Duração da splash screen em milissegundos (por exemplo, 4 segundos)
        int SPLASH_SCREEN_TIME_OUT = 4000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                // Iniciar a Main Activity após o tempo de espera
                Intent intent = new Intent(Splash.this, TelaInicialActivity.class);
                startActivity(intent);


                // Fechar a Splash Activity
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);





    }
}