package com.example.oneservicosopticos.helpers;

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
    private ImageView markerVerticalBar, markerLeftBar, markerRigthBar;
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
        markerLeftCross = createMarker(R.drawable.cross_marker_left);
        markerRightCross = createMarker(R.drawable.cross_marker);
        markerVerticalBar = createMarker(R.drawable.vertical_bar);
        markerLeftBar = createMarker(R.drawable.horizontal_bar_left);
        markerRigthBar = createMarker(R.drawable.horizontal_bar);
        markerLeftL = createMarker(R.drawable.l_marker); // Marcador L esquerdo
        markerRightL = createMarker(R.drawable.l_marker_mirror); // Marcador L direito espelhado

        // Define posições iniciais dos marcadores
        setupInitialMarkerPositions();
    }

    private ImageView createMarker(int drawableRes) {
        ImageView marker = new ImageView(this);
        marker.setImageResource(drawableRes);
        marker.setLayoutParams(new FrameLayout.LayoutParams(200, 200)); // Tamanho padrão
        marker.setOnTouchListener(new MarkerTouchListener());
        ((FrameLayout) findViewById(R.id.markerContainer)).addView(marker);
        return marker;
    }

    private void setupInitialMarkerPositions() {
        FrameLayout.LayoutParams params;

        // Left cross
        params = (FrameLayout.LayoutParams) markerLeftCross.getLayoutParams();
        params.leftMargin = 150;
        params.topMargin = 200;
        markerLeftCross.setLayoutParams(params);

        // Right cross
        params = (FrameLayout.LayoutParams) markerRightCross.getLayoutParams();
        params.leftMargin = 350;
        params.topMargin = 200;
        markerRightCross.setLayoutParams(params);

        // Vertical bar
        params = (FrameLayout.LayoutParams) markerVerticalBar.getLayoutParams();
        params.leftMargin = 500;
        params.topMargin = 200;
        params.height = 200;
        markerVerticalBar.setLayoutParams(params);

        // Top horizontal bar
        params = (FrameLayout.LayoutParams) markerLeftBar.getLayoutParams();
        params.leftMargin = 200;
        params.topMargin = 100;
        params.width = 300;
        markerLeftBar.setLayoutParams(params);

        // Bottom horizontal bar
        params = (FrameLayout.LayoutParams) markerRigthBar.getLayoutParams();
        params.leftMargin = 200;
        params.topMargin = 400;
        params.width = 300;
        markerRigthBar.setLayoutParams(params);

        // Left L
        params = (FrameLayout.LayoutParams) markerLeftL.getLayoutParams();
        params.leftMargin = 50;
        params.topMargin = 300;
        markerLeftL.setLayoutParams(params);

        // Right L (mirrored)
        params = (FrameLayout.LayoutParams) markerRightL.getLayoutParams();
        params.leftMargin = 450;
        params.topMargin = 300;
        markerRightL.setLayoutParams(params);
    }

    private void calculateMeasurements() {
        final double creditCardWidth = 85.60;

        float[] centerLeftCross = getCenterCoordinates(markerLeftCross);
        float[] centerRightCross = getCenterCoordinates(markerRightCross);
        float[] centerVerticalBar = getCenterCoordinates(markerVerticalBar);
        float[] topLeftL = getTopCoordinates(markerLeftL);
        float[] topRightL = getTopCoordinates(markerRightL);

        // Usando double para cálculos
        double dnpDireito = calculateDistance(centerLeftCross, centerVerticalBar);
        double dnpEsquerdo = calculateDistance(centerRightCross, centerVerticalBar);
        double alturaDireito = calculateHeight(centerLeftCross, topLeftL);
        double alturaEsquerdo = calculateHeight(centerRightCross, topRightL);
        double medidaCartao = calculateDistance(topLeftL, topRightL);

        // Cálculo do fator de conversão de pixels para milímetros
        double pixelToMmFactor = creditCardWidth / medidaCartao;
        dnpDireito *= pixelToMmFactor;
        dnpEsquerdo *= pixelToMmFactor;
        alturaDireito *= pixelToMmFactor;
        alturaEsquerdo *= pixelToMmFactor;

        // ajustar toast paara fica mais legivel e com menos casas decimais
        Toast.makeText(MarkersActivity.this, "DPD =" + dnpDireito + "DPE =" + dnpEsquerdo + "ALtD =" + alturaDireito + "AltE =" + alturaEsquerdo , Toast.LENGTH_LONG).show();


        //    aqui ajustei para enviar dados para "DadosFragmentPedidos"  e lá recebi dentro do OnCreatView . mas nao funciona ...


        finish();
    }

    private float[] getCenterCoordinates(View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        float centerX = location[0] + view.getWidth() / 2f;
        float centerY = location[1] + view.getHeight() / 2f;
        return new float[]{centerX, centerY};
    }

    private float[] getTopCoordinates(View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        float topX = location[0] + view.getWidth() / 2f;
        float topY = location[1];
        return new float[]{topX, topY};
    }

    private double calculateDistance(float[] point1, float[] point2) {
        return Math.sqrt(Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
    }

    private double calculateHeight(float[] point1, float[] point2) {
        return Math.abs(point2[1] - point1[1]);
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
