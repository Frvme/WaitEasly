package com.example.waiteasly;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CurrentTicketInfos extends Fragment {

    private TextView idText;
    private TextView nbres;
    private int nbperso = 0;
    private WaitEasilyAPI waitEasilyAPI;
    public View myView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.current_ticket_fragment, container, false);
        idText = myView.findViewById(R.id.ticketId);
        nbres = myView.findViewById(R.id.nbres);

        idText.setText(getArguments().getString("id"));

        System.out.println("nbPersonBefore " + getArguments().getString("nb"));
        nbres.setText(getArguments().getString("nb"));

//        getResponse();
        return myView;

    }

//    public void getResponse() {

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://78.192.197.104:8085/web/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        waitEasilyAPI = retrofit.create(WaitEasilyAPI.class);
//        //Response<ResponseBody> rsp = waitEasilyAPI.getCurrentTicket("countTicketBefore", idText.getText().toString());
//        //nbres.setText(rsp.body().toString());
//
//
//        Call<List<Ticket>> call = waitEasilyAPI.getCurrentTicket("countTicketBefore", idText.getText().toString());
//        System.out.println("Call " + call.request().toString());
//
//        call.enqueue(new Callback<List<Ticket>>() {
//            @Override
//            public void onResponse(Call<List<Ticket>> call, Response<List<Ticket>> response) {
//                Log.i("onResponse", response.body().toString());
//                System.out.println(response.body());
//                if (response.isSuccessful()) {
//
//                    if (response.body() != null) {
//                        Log.i("onSuccess", response.body().toString());
//
//                        List<Ticket> t = response.body();
//
//                        for(Ticket ticket : t) nbres.setText(ticket.getNbPerso());
//
////                        nbres.setText(t.getNbPerso());
//                        String jsonTicket = response.body().toString();
//                        System.out.println("  JSON DATA  " + jsonTicket.toString());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Ticket>> call, Throwable t) {
//
//            }
//        });
//    }

//    public void getPost() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://jsonplaceholder.typicode.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        waitEasilyAPI = retrofit.create(WaitEasilyAPI.class);
//
//        Call<List<Ticket>> call = waitEasilyAPI.getTickets();
//
//        System.out.println("Call " + call.request().toString());
//
//        call.enqueue(new Callback<List<Ticket>>() {
//            @Override
//            public void onResponse(Call<List<Ticket>> call, Response<List<Ticket>> response) {
//                nbres.setText(response.body().toString());
//                System.out.println("¤¤¤¤¤¤¤  " + nbres.getText().toString());
//            }
//
//            @Override
//            public void onFailure(Call<List<Ticket>> call, Throwable t) {
//
//            }
//        });
//
//
//    }

}
