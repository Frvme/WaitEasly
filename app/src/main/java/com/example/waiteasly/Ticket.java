package com.example.waiteasly;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ticket implements Serializable {

    @SerializedName("nbTicketBefore")
    private int nbPerso;

    public int getNbPerso() {
        return nbPerso;
    }
}
