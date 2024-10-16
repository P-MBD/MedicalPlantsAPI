package com.example.medicalplants.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicalplants.R;
import com.example.medicalplants.model.MedicalPlant;

import java.util.ArrayList;
import java.util.List;

public class MedicalPlantAdapter extends RecyclerView.Adapter<MedicalPlantAdapter.MedicalPlantViewHolder> {
    private List<MedicalPlant> medicalPlants = new ArrayList<>();

    @NonNull
    @Override
    public MedicalPlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medical_plant, parent, false);
        return new MedicalPlantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicalPlantViewHolder holder, int position) {
        MedicalPlant plant = medicalPlants.get(position);
        holder.plantNameTextView.setText(plant.getPlantsName());
        // Set other fields here if needed
    }

    @Override
    public int getItemCount() {
        return medicalPlants.size();
    }

    public void setMedicalPlants(List<MedicalPlant> medicalPlants) {
        this.medicalPlants = medicalPlants;
        notifyDataSetChanged();
    }

    public static class MedicalPlantViewHolder extends RecyclerView.ViewHolder {
        TextView plantNameTextView;

        public MedicalPlantViewHolder(@NonNull View itemView) {
            super(itemView);
            plantNameTextView = itemView.findViewById(R.id.plant_name_text_view);
        }
    }
}
