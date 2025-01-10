package com.example.oneservicosopticos;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PedidoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pedido);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        // Obter os arrays de strings do resources
        String[] grauItems = getResources().getStringArray(R.array.spinner_grau_items);
        String[] eixoItems = getResources().getStringArray(R.array.spinner_eixo_items);
        String[] tipoMontagem = getResources().getStringArray(R.array.spinner_tipo_montagem);

        // Configurar ArrayAdapter para grau (de -4,00 a +4,00)
        ArrayAdapter<String> grauAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, grauItems);
        grauAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Configurar ArrayAdapter para eixo (de 0 a 180)
        ArrayAdapter<String> eixoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, eixoItems);
        eixoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //configurar ArrayAdapter para tipo de armacao
        ArrayAdapter<String> tipoArmacaoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipoMontagem);
        tipoArmacaoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        // Configurar os Spinners
        Spinner spinner1 = findViewById(R.id.spinnerEsfOd);
        Spinner spinner2 = findViewById(R.id.spinnerCilOd);
        Spinner spinner3 = findViewById(R.id.spinnerEixoOd);
        Spinner spinner4 = findViewById(R.id.spinnerEsfOe);
        Spinner spinner5 = findViewById(R.id.spinnerCilOe);
        Spinner spinner6 = findViewById(R.id.spinnerEixoOe);
        Spinner spinner7 = findViewById(R.id.spinnerTipoMontagem);

        spinner1.setAdapter(grauAdapter);
        spinner2.setAdapter(grauAdapter);
        spinner4.setAdapter(grauAdapter);
        spinner5.setAdapter(grauAdapter);

        spinner3.setAdapter(eixoAdapter); // Usar array de 0 a 180
        spinner6.setAdapter(eixoAdapter); // Usar array de 0 a 180

        spinner7.setAdapter(tipoArmacaoAdapter);

        // Definir a seleção inicial dos Spinners para "0,00"
        setInitialSelection(spinner1, grauItems, "0,00");
        setInitialSelection(spinner2, grauItems, "0,00");
        setInitialSelection(spinner4, grauItems, "0,00");
        setInitialSelection(spinner5, grauItems, "0,00");
    }

    // Metodo auxiliar para definir a seleção inicial
    private void setInitialSelection(Spinner spinner, String[] items, String value) {
        int position = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(value)) {
                position = i;
                break;
            }
        }
        spinner.setSelection(position);
    }




}
