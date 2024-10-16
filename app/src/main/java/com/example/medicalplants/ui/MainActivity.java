package com.example.medicalplants.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicalplants.R;
import com.example.medicalplants.adapter.MedicalPlantAdapter;
import com.example.medicalplants.model.MedicalPlant;
import com.example.medicalplants.viewmodel.MedicalPlantViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private MedicalPlantAdapter adapter;
    private MedicalPlantViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MedicalPlantAdapter();
        recyclerView.setAdapter(adapter);

        viewModel = new MedicalPlantViewModel();
        viewModel.getMedicalPlants().observe(this, new Observer<List<MedicalPlant>>() {
            @Override
            public void onChanged(List<MedicalPlant> medicalPlants) {
                if (medicalPlants != null) {
                    adapter.setMedicalPlants(medicalPlants);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Failed to load data");
                }
            }
        });
    }
}
