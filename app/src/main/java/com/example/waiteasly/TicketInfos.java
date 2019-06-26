package com.example.waiteasly;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TicketInfos extends Fragment {

    private TextView idText;
    private TextView nbres;
    private int nbperso=0;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    public View myView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView=inflater.inflate(R.layout.ticket_fragment, container, false);
        idText=myView.findViewById(R.id.ticketId);

        idText.setText(getArguments().getString("id"));
        System.out.println("XXXXX  IdText : XXXXXX " + getArguments().getString("id"));
        System.out.println("XXXXX  IdText : XXXXXX " + idText.getText().toString());

        //nbres.setText((Integer.toString(nbperso)));
        //nbperso=(Integer.parseInt(getArguments().getString("id"))-1);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.22.0.34:8989/web/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        getCurrentTicket(idText.getText().toString());

        return myView;

    }

    private void getCurrentTicket(String id) {
        Call<List<Ticket>> call = jsonPlaceHolderApi.getTicket("countTicketBefore", id);

        call.enqueue(new Callback<List<Ticket>>() {
            @Override
            public void onResponse(Call<List<Ticket>> call, Response<List<Ticket>> response) {

                if (!response.isSuccessful()) {
                    nbres.setText("Code : " + response.code());
                    return;
                }

                List<Ticket> tickets = response.body();

                for (Ticket ticket : tickets) {
                    nbperso = ticket.getNbPerso();

                    nbres.append(String.valueOf(nbperso).toString());
                }
            }


            @Override
            public void onFailure(Call<List<Ticket>> call, Throwable t) {

                idText.setText(t.getMessage());
            }
        });
    }
}
