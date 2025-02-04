package com.example.oneservicosopticos.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.oneservicosopticos.R;
import com.example.oneservicosopticos.venda.Venda;
import com.example.oneservicosopticos.activity.ui.main.SectionsPagerAdapter;
import com.example.oneservicosopticos.databinding.ActivityPedidoLenteAcabadaBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.view.View;
import android.widget.Toast;

public class PedidoLenteAcabadaActivity extends AppCompatActivity {
    private ActivityPedidoLenteAcabadaBinding binding;
    private ViewPager2 viewPager;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPedidoLenteAcabadaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewPager = binding.viewPager;
        tabs = binding.tabs;
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, this);
        viewPager.setAdapter(sectionsPagerAdapter);
        new TabLayoutMediator(tabs, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText(R.string.tab_text_1);
                    break;
                case 1:
                    tab.setText(R.string.tab_text_2);
                    break;
                case 2:
                    tab.setText(R.string.tab_text_3);
                    break;
            }
        }).attach(); // aqui vamos salvar o pedido ao fim do preenchimento de dados ....
        binding.extendedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Crie um objeto Venda com os dados preenchidos
                Venda venda = new Venda();
                // Preencha o objeto venda com dados dos campos de entrada (EditText, ToggleButton, etc.)
                venda.setNome("Nome do Cliente");
                venda.setSobrenome("Sobrenome do Cliente");
                // ... (preencha todos os outros atributos)

                // Obtenha o CPF do cliente (presume-se que haja um campo EditText ou algo similar para o CPF)
                String cpf = venda.getCpf();

                // Obtenha a referência do Firebase Database
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("clientes");

                // Salve os dados no Firebase usando o CPF como chave
                databaseReference.child(cpf).setValue(venda)
                        .addOnSuccessListener(aVoid -> {
                            Toast.makeText(PedidoLenteAcabadaActivity.this, "Dados do cliente salvos com sucesso!", Toast.LENGTH_SHORT).show();
                        })
                        .addOnFailureListener(e -> {
                            Toast.makeText(PedidoLenteAcabadaActivity.this, "Falha ao salvar dados do cliente: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        });
            }
        });




    }
}