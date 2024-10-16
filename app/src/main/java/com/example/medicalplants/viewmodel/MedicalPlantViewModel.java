package com.example.medicalplants.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.medicalplants.model.MedicalPlant;
import com.example.medicalplants.repository.MedicalPlantRepository;

import java.util.List;

public class MedicalPlantViewModel extends ViewModel {
    private MutableLiveData<List<MedicalPlant>> medicalPlants;
    private MedicalPlantRepository repository;

    public MedicalPlantViewModel() {
        repository = new MedicalPlantRepository();
        medicalPlants = new MutableLiveData<>();
    }

    public LiveData<List<MedicalPlant>> getMedicalPlants() {
        if (medicalPlants.getValue() == null) {
            medicalPlants = repository.getMedicalPlants();
        }
        return medicalPlants;
    }
}
