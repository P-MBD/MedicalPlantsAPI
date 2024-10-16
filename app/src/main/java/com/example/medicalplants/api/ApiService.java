package com.example.medicalplants.api;

import com.example.medicalplants.model.MedicalPlant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("medical-plants/") // URL endpoint for fetching medical plants
    Call<List<MedicalPlant>> getMedicalPlants();
}
