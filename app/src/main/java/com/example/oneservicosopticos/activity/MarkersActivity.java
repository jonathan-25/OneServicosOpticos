package com.example.oneservicosopticos.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.oneservicosopticos.R;

public class MarkersActivity extends AppCompatActivity {

    private ImageView photoView;
    private Button calculateButton;

    private String photoPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markers);

        // Inicializa os componentes
        photoView = findViewById(R.id.photoView);
        calculateButton = findViewById(R.id.calculateButton);

        // Obtém o caminho da foto da Intent
        photoPath = getIntent().getStringExtra("photoPath");

        android.util.Log.d("MarkersActivity", "Caminho da foto: " + photoPath);

        if (photoPath != null) {
            loadPhoto();
        } else {
            Toast.makeText(this, "Erro ao carregar a imagem", Toast.LENGTH_SHORT).show();
            finish(); // Fecha a atividade em caso de erro
        }

        // Configura o botão de cálculo
        calculateButton.setOnClickListener(v -> {
            android.util.Log.d("MarkersActivity", "Botão de cálculo clicado.");
            // Aqui você implementará a lógica para calcular as medidas
            Toast.makeText(this, "Cálculo realizado com sucesso!", Toast.LENGTH_SHORT).show();
        });
    }

    private void loadPhoto() {
        android.util.Log.d("MarkersActivity", "Carregando foto do caminho: " + photoPath);

        Bitmap bitmap = BitmapFactory.decodeFile(photoPath);
        if (bitmap != null) {
            photoView.setImageBitmap(bitmap);
            android.util.Log.d("MarkersActivity", "Imagem carregada com sucesso");
        } else {
            Toast.makeText(this, "Erro ao processar a imagem", Toast.LENGTH_SHORT).show();
        }
    }
}
