package com.example.oneservicosopticos.activity.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oneservicosopticos.R;
import com.example.oneservicosopticos.activity.CameraActivity;
import com.example.oneservicosopticos.activity.MarkersActivity;

import java.util.Locale;

public class DadosServicoFragment extends Fragment {

    private ActivityResultLauncher<String[]> permissionLauncher;
    private EditText editDnpD, editDnpE, editAlturaD, editAlturaE;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Inicializa o launcher para solicitar permissões
        permissionLauncher = registerForActivityResult(
                new ActivityResultContracts.RequestMultiplePermissions(),
                result -> {
                    Boolean cameraPermissionGranted = result.getOrDefault(Manifest.permission.CAMERA, false);

                    android.util.Log.d("DadosServicoFragment", "Permissão de câmera concedida: " + cameraPermissionGranted);

                    if (cameraPermissionGranted != null && cameraPermissionGranted) {
                        openCameraActivity();
                    } else {
                        Toast.makeText(getContext(), "Permissão de câmera necessária", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o layout
        View view = inflater.inflate(R.layout.fragment_dados_servico, container, false);

        // Inicializa os campos EditText
        editDnpD = view.findViewById(R.id.editDnpD);
        editDnpE = view.findViewById(R.id.editDnpE);
        editAlturaD = view.findViewById(R.id.editAlturaD);
        editAlturaE = view.findViewById(R.id.editAlturaE);


        Button openCameraButton = view.findViewById(R.id.openCameraButton);
        openCameraButton.setOnClickListener(v -> checkPermissionsAndOpenCamera());


        //      aqui estava pegando os dados da MarkersActivity ...

        return view;
    }

    private void checkPermissionsAndOpenCamera() {
        android.util.Log.d("DadosServicoFragment", "Verificando permissões de câmera");

        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            openCameraActivity();
        } else {
            // Solicita a permissão de câmera
            permissionLauncher.launch(new String[]{Manifest.permission.CAMERA});
        }
    }

    private void openCameraActivity() {
        android.util.Log.d("DadosLenteFragment", "Abrindo a CameraActivity");
        Intent intent = new Intent(getActivity(), CameraActivity.class);
        startActivity(intent);
    }



    // Método para chamar a MarkersActivity e enviar a imagem
    public void openMarkersActivity(String photoPath) {
        Intent intent = new Intent(getActivity(), MarkersActivity.class);
        intent.putExtra("photoPath", photoPath);
        startActivity(intent);
    }

    public void updateMeasurements(double dnpDireito, double dnpEsquerdo, double alturaDireito, double alturaEsquerdo) {
        // Atualiza os campos EditText com os valores recebidos
        editDnpD.setText(String.format(Locale.getDefault(), "%.2f", dnpDireito));
        editDnpE.setText(String.format(Locale.getDefault(), "%.2f", dnpEsquerdo));
        editAlturaD.setText(String.format(Locale.getDefault(), "%.2f", alturaDireito));
        editAlturaE.setText(String.format(Locale.getDefault(), "%.2f", alturaEsquerdo));
    }


}
