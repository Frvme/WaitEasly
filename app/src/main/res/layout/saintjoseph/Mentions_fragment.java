package com.example.saintjoseph;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Mentions_fragment extends  Fragment {

    private  View myView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        myView = inflater.inflate(R.layout.mentions_legales_fragment, container, false);

     return  myView;
    }

}
