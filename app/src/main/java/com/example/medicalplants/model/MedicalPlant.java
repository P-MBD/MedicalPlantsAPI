package com.example.medicalplants.model;

import com.google.gson.annotations.SerializedName;

public class MedicalPlant {
    @SerializedName("Id")
    private int id;

    @SerializedName("PlantsName")
    private String plantsName;

    @SerializedName("SCName")
    private String scientificName;

    @SerializedName("family")
    private String family;

    @SerializedName("Description")
    private String description;

    @SerializedName("ChemicalCompounds")
    private String chemicalCompounds;

    @SerializedName("Habitat")
    private String habitat;

    @SerializedName("Agriculture")
    private String agriculture;

    @SerializedName("SoilType")
    private String soilType;

    @SerializedName("WaterReq")
    private String waterRequirements;

    @SerializedName("KodeNeeds")
    private String codeNeeds;

    @SerializedName("Disease")
    private String disease;

    @SerializedName("Flowring")
    private String flowering;

    @SerializedName("Properties")
    private String properties;

    @SerializedName("img")
    private String img;

    @SerializedName("img2")
    private String img2;

    @SerializedName("fav")
    private int fav;

    public int getId() {
        return id;
    }

    public String getPlantsName() {
        return plantsName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getFamily() {
        return family;
    }

    public String getDescription() {
        return description;
    }

    public String getChemicalCompounds() {
        return chemicalCompounds;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getAgriculture() {
        return agriculture;
    }

    public String getSoilType() {
        return soilType;
    }

    public String getWaterRequirements() {
        return waterRequirements;
    }

    public String getCodeNeeds() {
        return codeNeeds;
    }

    public String getDisease() {
        return disease;
    }

    public String getFlowering() {
        return flowering;
    }

    public String getProperties() {
        return properties;
    }

    public String getImg() {
        return img;
    }

    public String getImg2() {
        return img2;
    }

    public int getFav() {
        return fav;
    }
}
