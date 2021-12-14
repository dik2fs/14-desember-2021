package com.rsudalihsan.ibs.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.rsudalihsan.ibs.activity.frament.AntrianRumahSakitFragment;
import com.rsudalihsan.ibs.activity.frament.AntrianSayaFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 1 :
                return new AntrianRumahSakitFragment();
        }
        return new AntrianSayaFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
