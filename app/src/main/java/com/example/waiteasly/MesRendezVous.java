package com.example.waiteasly;

import android.os.Bundle;
import android.support.annotation.NonNull;
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


public class MesRendezVous extends Fragment {

    private TextView textViewResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private View myView;


    public MesRendezVous() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_mes_rendez_vous, container, false);

        textViewResult = myView.findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        getCurrentTicket();

        return myView;
    }

    private void getCurrentTicket() {
        Call<List<Ticket>> call = jsonPlaceHolderApi.getTicket("2");

        call.enqueue(new Callback<List<Ticket>>() {
            @Override
            public void onResponse(Call<List<Ticket>> call, Response<List<Ticket>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code : " + response.code());
                    return;
                }

                List<Ticket> tickets = response.body();

                for (Ticket ticket : tickets) {
                    String content = "";
                    content += "ID: " + ticket.getId() + "\n";
                    content += "User ID: " + ticket.getUserId() + "\n";
                    content += "Title: " + ticket.getTitle() + "\n";
                    content += "Text: " + ticket.getText() + "\n\n";

                    textViewResult.append(content);

                }
            }


            @Override
            public void onFailure(Call<List<Ticket>> call, Throwable t) {

                textViewResult.setText(t.getMessage());
            }
        });
    }
}
