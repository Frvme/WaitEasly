package com.example.saintjoseph;

import com.google.gson.annotations.SerializedName;

public class Contact {

    @SerializedName("Nom")
    private String nom;
    @SerializedName("Prenom")
    private  String prenom;
    @SerializedName("Fonction")
    private String fonction;
    @SerializedName("Service")
    private String service;
    @SerializedName("Tel")
    private  String tel;

    public Contact(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFonction() {
        return fonction;
    }


    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
