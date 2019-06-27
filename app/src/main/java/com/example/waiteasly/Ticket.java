package com.example.waiteasly;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ticket {

    @SerializedName("nbTicketBefore")
    @Expose
    private String nbPerso;

    public String getNbPerso() {
        return nbPerso;
    }
}
