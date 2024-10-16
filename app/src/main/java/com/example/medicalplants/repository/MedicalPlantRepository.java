package com.example.medicalplants.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.medicalplants.api.ApiService;
import com.example.medicalplants.model.MedicalPlant;
import com.example.medicalplants.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MedicalPlantRepository {
    private static final String TAG = "MedicalPlantRepository";
    private ApiService apiService;

    public MedicalPlantRepository() {
        apiService = RetrofitClient.getApiService();
    }

    public MutableLiveData<List<MedicalPlant>> getMedicalPlants() {
        MutableLiveData<List<MedicalPlant>> medicalPlantsData = new MutableLiveData<>();

        apiService.getMedicalPlants().enqueue(new Callback<List<MedicalPlant>>() {
            @Override
            public void onResponse(Call<List<MedicalPlant>> call, Response<List<MedicalPlant>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(TAG, "API Response: " + response.body().toString());
                    medicalPlantsData.setValue(response.body());
                } else {
                    Log.d(TAG, "API Response unsuccessful or empty");
                    medicalPlantsData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<MedicalPlant>> call, Throwable t) {
                Log.e(TAG, "Error loading data: " + t.getMessage());
                medicalPlantsData.setValue(null);
            }
        });

        return medicalPlantsData;
    }
}
