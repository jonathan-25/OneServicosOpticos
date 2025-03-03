package com.example.oneservicosopticos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oneservicosopticos.R;

import java.util.ArrayList;

public class TelaInicialActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_inicial);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });









    }

    public void escolhaTipoVenda(View view) {

        Intent intent = new Intent(TelaInicialActivity.this, EscolhaTipoVendaActivity.class);
        startActivity(intent);

    }

    public void minhasCompras(View view) {
    }

    public void Contato(View view) {
    }

    public void cadastroCliente(View view) {

        Intent intent = new Intent(TelaInicialActivity.this, CadastroClienteActivity.class);
        startActivity(intent);

    }
}