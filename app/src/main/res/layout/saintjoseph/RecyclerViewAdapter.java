package com.example.saintjoseph;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<com.example.saintjoseph.ViewHolder> {
    private List<Contact> liste;

    public RecyclerViewAdapter(List<Contact> liste)
    {
        this.liste=liste;
    }


    @Override
    public com.example.saintjoseph.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent,false);

        com.example.saintjoseph.ViewHolder mViewHolder=new com.example.saintjoseph.ViewHolder(itemView);

       return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final com.example.saintjoseph.ViewHolder viewHolder, int i) {

        viewHolder.name.setText(liste.get(i).getNom()+ " " + liste.get(i).getPrenom());
        viewHolder.tel.setText("Tel : +3314412"+liste.get(i).getTel());

        if(liste.get(i).getFonction()=="")
            viewHolder.fonction.setText("Fonction : N/A");
        else
            viewHolder.fonction.setText("Fonction : "+liste.get(i).getFonction());
        if(liste.get(i).getService()=="")
            viewHolder.service.setText("Service : N/A");
        else
            viewHolder.service.setText("Service : "+ liste.get(i).getService());



    }

    @Override
    public int getItemCount() {
        return liste.size();
    }
}
