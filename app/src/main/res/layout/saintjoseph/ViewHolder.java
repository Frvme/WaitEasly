package com.example.saintjoseph;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView name,prenom,tel,fonction,service;
    public final  View view;
     ViewHolder(@NonNull View view) {
        super(view);
        this.view=view;
        name= view.findViewById(R.id.name);
        tel=view.findViewById(R.id.tel);
        fonction=view.findViewById(R.id.fonction);
        service=view.findViewById(R.id.service);

     }
}
