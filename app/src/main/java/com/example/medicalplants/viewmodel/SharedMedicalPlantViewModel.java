package com.example.medicalplants.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.medicalplants.model.MedicalPlant;
import com.example.medicalplants.repository.MedicalPlantRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SharedMedicalPlantViewModel extends ViewModel {
    private MutableLiveData<List<MedicalPlant>> medicalPlants;
    private MutableLiveData<MedicalPlant> selectedPlant; // برای نگهداری یک گیاه خاص
    private MedicalPlantRepository repository;

    public SharedMedicalPlantViewModel() {
        repository = new MedicalPlantRepository();
        medicalPlants = new MutableLiveData<>();
        selectedPlant = new MutableLiveData<>(); // مقداردهی اولیه
    }

    public LiveData<List<MedicalPlant>> getMedicalPlants() {
        if (medicalPlants.getValue() == null || medicalPlants.getValue().isEmpty()) {
            loadMedicalPlants(); // درخواست داده‌ها از Repository
        }
        return medicalPlants;
    }

    private void loadMedicalPlants() {
        repository.getMedicalPlants().observeForever(new Observer<List<MedicalPlant>>() {
            @Override
            public void onChanged(List<MedicalPlant> plants) {
                medicalPlants.setValue(plants);  // بروزرسانی LiveData با داده‌های دریافتی
                Log.d("SharedMedicalPlantViewModel", "Loaded medical plants: " + plants);
            }
        });
    }

    // این متد برای دریافت اطلاعات یک گیاه خاص بر اساس plantId است
    public LiveData<MedicalPlant> getMedicalPlantById(int plantId) {
        selectedPlant = repository.getMedicalPlantById(plantId); // استفاده از repository برای دریافت داده‌ها
        return selectedPlant; // بازگرداندن داده‌های LiveData
    }
}
