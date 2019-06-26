package com.example.waiteasly;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ticket implements Serializable {

    private int userId;

    private int id;

    private String title;

    @SerializedName("body")
    private String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
