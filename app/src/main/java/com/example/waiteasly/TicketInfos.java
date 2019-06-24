package com.example.waiteasly;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;

public class TicketInfos extends Fragment {

    private TextView idText;
    private TextView nbres;
    private int nbperso=0;
    public View myView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView=inflater.inflate(R.layout.ticket_fragment, container, false);
        idText=myView.findViewById(R.id.ticketId);
        nbres=myView.findViewById(R.id.nbres);
        nbperso=(Integer.parseInt(getArguments().getString("id"))-1);
        idText.setText(getArguments().getString("id"));
        nbres.setText((Integer.toString(nbperso)));

        return myView;
    }
}
