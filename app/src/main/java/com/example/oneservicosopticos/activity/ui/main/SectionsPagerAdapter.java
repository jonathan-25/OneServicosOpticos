package com.example.oneservicosopticos.activity.ui.main;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.oneservicosopticos.R;
import com.example.oneservicosopticos.fragments.DadosClienteFragment;
import com.example.oneservicosopticos.fragments.DadosLenteFragment;
import com.example.oneservicosopticos.fragments.DadosServicoFragment;

public class SectionsPagerAdapter extends FragmentStateAdapter {

    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3}; // Adicionei uma terceira tab
    private final Context mContext;

    public SectionsPagerAdapter(FragmentActivity activity, Context context) {
        super(activity);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DadosClienteFragment();
            case 1:
                return new DadosLenteFragment();
            case 2:
                return new DadosServicoFragment();
            default:
                return new DadosClienteFragment();
        }
    }

    @Override
    public int getItemCount() {
        // Show 3 total pages.
        return TAB_TITLES.length; // Use o tamanho do array para definir o número de tabs
    }
}