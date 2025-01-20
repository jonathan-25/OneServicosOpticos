package com.example.oneservicosopticos.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.oneservicosopticos.R;

public class MarkersActivity extends AppCompatActivity {

    private ImageView photoView;
    private Button calculateButton;

    // Marcadores
    private ImageView markerLeftCross, markerRightCross;
    private ImageView markerVerticalBar, markerTopBar, markerBottomBar;
    private ImageView markerLeftL, markerRightL;

    private String photoPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markers);

        photoView = findViewById(R.id.photoView);
        calculateButton = findViewById(R.id.calculateButton);

        // Obtém o caminho da foto da Intent
        photoPath = getIntent().getStringExtra("photoPath");
        if (photoPath != null) {
            loadPhoto();
        } else {
            Toast.makeText(this, "Erro ao carregar a imagem", Toast.LENGTH_SHORT).show();
            finish();
        }

        // Inicializa os marcadores
        initializeMarkers();

        // Configura a lógica do botão Calcular
        calculateButton.setOnClickListener(v -> calculateMeasurements());
    }

    private void loadPhoto() {
        Bitmap bitmap = BitmapFactory.decodeFile(photoPath);
        if (bitmap != null) {
            photoView.setImageBitmap(bitmap);
        } else {
            Toast.makeText(this, "Erro ao processar a imagem", Toast.LENGTH_SHORT).show();
        }
    }

    private void initializeMarkers() {
        // Criação e configuração dos marcadores
        markerLeftCross = createMarker(R.drawable.cross_marker);
        markerRightCross = createMarker(R.drawable.cross_marker);
        markerVerticalBar = createMarker(R.drawable.vertical_bar);
        markerTopBar = createMarker(R.drawable.horizontal_bar);
        markerBottomBar = createMarker(R.drawable.horizontal_bar);
        markerLeftL = createMarker(R.drawable.l_marker); // Marcador L esquerdo
        markerRightL = createMarker(R.drawable.l_marker_mirror); // Marcador L direito espelhado

        // Define posições iniciais dos marcadores
        setupInitialMarkerPositions();
    }

    private ImageView createMarker(int drawableRes) {
        ImageView marker = new ImageView(this);
        marker.setImageResource(drawableRes);
        marker.setLayoutParams(new FrameLayout.LayoutParams(50, 50)); // Tamanho padrão
        marker.setOnTouchListener(new MarkerTouchListener());
        ((FrameLayout) findViewById(R.id.markerContainer)).addView(marker);
        return marker;
    }

    private void setupInitialMarkerPositions() {
        FrameLayout.LayoutParams params;

        // Left cross
        params = (FrameLayout.LayoutParams) markerLeftCross.getLayoutParams();
        params.leftMargin = 100;
        params.topMargin = 200;
        markerLeftCross.setLayoutParams(params);

        // Right cross
        params = (FrameLayout.LayoutParams) markerRightCross.getLayoutParams();
        params.leftMargin = 600;
        params.topMargin = 200;
        markerRightCross.setLayoutParams(params);

        // Vertical bar
        params = (FrameLayout.LayoutParams) markerVerticalBar.getLayoutParams();
        params.leftMargin = 350;
        params.topMargin = 200;
        params.height = 200;
        markerVerticalBar.setLayoutParams(params);

        // Top horizontal bar
        params = (FrameLayout.LayoutParams) markerTopBar.getLayoutParams();
        params.leftMargin = 200;
        params.topMargin = 100;
        params.width = 300;
        markerTopBar.setLayoutParams(params);

        // Bottom horizontal bar
        params = (FrameLayout.LayoutParams) markerBottomBar.getLayoutParams();
        params.leftMargin = 200;
        params.topMargin = 400;
        params.width = 300;
        markerBottomBar.setLayoutParams(params);

        // Left L
        params = (FrameLayout.LayoutParams) markerLeftL.getLayoutParams();
        params.leftMargin = 50;
        params.topMargin = 300;
        markerLeftL.setLayoutParams(params);

        // Right L (mirrored)
        params = (FrameLayout.LayoutParams) markerRightL.getLayoutParams();
        params.leftMargin = 650;
        params.topMargin = 300;
        markerRightL.setLayoutParams(params);
    }

    private void calculateMeasurements() {
        // Placeholder para lógica de cálculo
        Toast.makeText(this, "Cálculo realizado com sucesso!", Toast.LENGTH_SHORT).show();
    }

    private class MarkerTouchListener implements View.OnTouchListener {

        private float dX, dY;

        @Override
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    dX = view.getX() - event.getRawX();
                    dY = view.getY() - event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    view.animate()
                            .x(event.getRawX() + dX)
                            .y(event.getRawY() + dY)
                            .setDuration(0)
                            .start();
                    break;
                default:
                    return false;
            }
            return true;
        }
    }
}
