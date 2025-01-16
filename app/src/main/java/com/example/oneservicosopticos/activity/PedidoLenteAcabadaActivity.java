package com.example.oneservicosopticos.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.example.oneservicosopticos.R;
import com.example.oneservicosopticos.activity.ui.main.SectionsPagerAdapter;
import com.example.oneservicosopticos.databinding.ActivityPedidoLenteAcabadaBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.snackbar.Snackbar;
import android.view.View;

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
        }).attach();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
    }
}