package com.example.medicalplants.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.medicalplants.ui.fragments.PlantDescriptionFragment;
import com.example.medicalplants.ui.fragments.PlantPropertiesFragment;
import com.example.medicalplants.ui.fragments.PlantUsageFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private int plantId;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, int plantId) {
        super(fragmentActivity);
        this.plantId = plantId;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return PlantDescriptionFragment.newInstance(plantId);
            case 1:
                return PlantPropertiesFragment.newInstance(plantId);
            case 2:
                return PlantUsageFragment.newInstance(plantId);
            default:
                return new Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // تعداد تب‌ها
    }
}
