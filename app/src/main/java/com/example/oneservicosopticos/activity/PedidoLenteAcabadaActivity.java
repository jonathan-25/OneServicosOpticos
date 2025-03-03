package com.example.oneservicosopticos.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.example.oneservicosopticos.R;
import com.example.oneservicosopticos.user.Venda;
import com.example.oneservicosopticos.activity.ui.main.SectionsPagerAdapter;
import com.example.oneservicosopticos.databinding.ActivityPedidoLenteAcabadaBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PedidoLenteAcabadaActivity extends AppCompatActivity {

    private EditText lenteOd, lenteOe, tratamento, observacoes, armacao, observacaoArmacao, horizontal, diagonal, vertical, ponte, haste, serie, incPantografica, distVertice, valorTotal, valorArmacao, valorTratamento, valorLenteOd, valorLenteOe;
    private TextView id;
    private RadioButton pesoD, pesoE;
    private ActivityPedidoLenteAcabadaBinding binding;
    private Date date;
    private DatePicker datePicker;

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
        }).attach();

        id = findViewById(R.id.textIdPedido);
        lenteOd = findViewById(R.id.editLenteOD);
        lenteOe = findViewById(R.id.editLenteOe);
        pesoD = findViewById(R.id.radioButtonD);
        pesoE = findViewById(R.id.radioButtonE);
        tratamento = findViewById(R.id.editTratamento);
        observacoes = findViewById(R.id.editObservacoes);
        armacao = findViewById(R.id.editArmacao);
        observacaoArmacao = findViewById(R.id.editObservacoes);
        horizontal = findViewById(R.id.editHorizontal);
        diagonal = findViewById(R.id.editDiagonal);
        vertical = findViewById(R.id.editVertical);
        ponte = findViewById(R.id.editPonte);
        haste = findViewById(R.id.editHaste);
        serie = findViewById(R.id.editSerie);
        incPantografica = findViewById(R.id.editIncPantog);
        distVertice = findViewById(R.id.editDistvertice);
        valorLenteOd = findViewById(R.id.editValorLenteOd);
        valorLenteOe = findViewById(R.id.editValorLenteOd);
        valorArmacao = findViewById(R.id.editValorArmacao);
        valorTratamento = findViewById(R.id.editValorTratamento);
        valorTotal = findViewById(R.id.editValorTotal);

        binding.extendedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Salvar a venda no Firebase
               // salvarVenda();
            }
        });

        datePicker = findViewById(R.id.datePicker);

        // Define a data atual no DatePicker
        Calendar calendario = Calendar.getInstance();
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        datePicker.init(ano, mes, dia, (view, year, monthOfYear, dayOfMonth) -> {
            String dataSelecionada = String.format(Locale.getDefault(), "%02d/%02d/%04d", dayOfMonth, (monthOfYear + 1), year);
            //Toast.makeText(getApplicationContext(), "Data selecionada: " + dataSelecionada, Toast.LENGTH_SHORT).show();


        });
    }

    private void salvarVenda() {
        // Objeto Venda com os dados preenchidos
        Venda venda = new Venda();

        // Preencha o objeto venda com dados dos campos de entrada
        venda.setId(id.getText().toString());
        venda.setLenteOd(lenteOd.getText().toString());
        venda.setLenteOe(lenteOe.getText().toString());
        venda.setTratamento(tratamento.getText().toString());
        venda.setObservacoes(observacoes.getText().toString());
        venda.setArmacao(armacao.getText().toString());
        venda.setObservacaoArmacao(observacaoArmacao.getText().toString());
        venda.setHorizontal(horizontal.getText().toString());
        venda.setDiagonal(diagonal.getText().toString());
        venda.setVertical(vertical.getText().toString());
        venda.setPonte(ponte.getText().toString());
        venda.setHaste(haste.getText().toString());
        venda.setSerie(serie.getText().toString());
        venda.setIncPantografica(incPantografica.getText().toString());
        venda.setDistVertice(distVertice.getText().toString());
        venda.setValorLenteOd(valorLenteOd.getText().toString());
        venda.setValorLenteOe(valorLenteOe.getText().toString());
        venda.setValorArmacao(valorArmacao.getText().toString());
        venda.setValorTratamento(valorTratamento.getText().toString());
        venda.setValorTotal(valorTotal.getText().toString());





        // Obtenha a referência do Firebase Database
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("vendas");

        // Salve os dados no Firebase usando o ID como chave
        databaseReference.child(venda.getId()).setValue(venda)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(PedidoLenteAcabadaActivity.this, "Venda salva com sucesso!", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(PedidoLenteAcabadaActivity.this, "Falha ao salvar venda: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

}
