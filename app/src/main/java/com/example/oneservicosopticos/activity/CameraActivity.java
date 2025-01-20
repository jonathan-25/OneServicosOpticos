package com.example.oneservicosopticos.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;

import com.example.oneservicosopticos.R;
import com.google.common.util.concurrent.ListenableFuture;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CameraActivity extends AppCompatActivity {

    private ImageCapture imageCapture;
    private ExecutorService cameraExecutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        PreviewView previewView = findViewById(R.id.previewView);
        Button captureButton = findViewById(R.id.captureButton);

        cameraExecutor = Executors.newSingleThreadExecutor();
        startCamera(previewView);

        captureButton.setOnClickListener(v -> takePhoto());
    }

    private void startCamera(PreviewView previewView) {
        android.util.Log.d("CameraActivity", "Iniciando a câmera");

        ListenableFuture<ProcessCameraProvider> cameraProviderFuture =
                ProcessCameraProvider.getInstance(this);

        cameraProviderFuture.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();

                Preview preview = new Preview.Builder().build();
                preview.setSurfaceProvider(previewView.getSurfaceProvider());

                imageCapture = new ImageCapture.Builder().build();

                CameraSelector cameraSelector = new CameraSelector.Builder()
                        .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                        .build();

                cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageCapture);

            } catch (Exception e) {
                android.util.Log.e("CameraActivity", "Erro ao iniciar a câmera: " + e.getMessage());
                Toast.makeText(this, "Erro ao iniciar a câmera: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, ContextCompat.getMainExecutor(this));
    }

    private void takePhoto() {
        File photoFile = new File(getExternalFilesDir(null), "photo.jpg");

        android.util.Log.d("CameraActivity", "Tirando foto e salvando em: " + photoFile.getAbsolutePath());

        ImageCapture.OutputFileOptions options = new ImageCapture.OutputFileOptions.Builder(photoFile).build();
        imageCapture.takePicture(options, ContextCompat.getMainExecutor(this), new ImageCapture.OnImageSavedCallback() {
            @Override
            public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {
                android.util.Log.d("CameraActivity", "Foto salva com sucesso");
                Intent intent = new Intent(CameraActivity.this, MarkersActivity.class);
                intent.putExtra("photoPath", photoFile.getAbsolutePath());
                startActivity(intent);
                finish();
            }

            @Override
            public void onError(@NonNull ImageCaptureException exception) {
                android.util.Log.e("CameraActivity", "Erro ao salvar a foto: " + exception.getMessage());
                Toast.makeText(CameraActivity.this, "Erro ao salvar a foto: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cameraExecutor.shutdown();
    }
}
