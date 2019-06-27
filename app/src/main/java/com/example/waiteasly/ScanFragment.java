package com.example.waiteasly;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.gson.JsonObject;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Lib Qr Code

public class ScanFragment extends Fragment {

    private Button scanQr;
    //Qr Code variable
    private IntentIntegrator scan;
    final Bundle bundle = new Bundle();
    final Bundle bundleApi = new Bundle();

    public ScanFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View myView = inflater.inflate(R.layout.scan_fragment, container, false);
        scanQr = myView.findViewById(R.id.scanQr);


        //Initialisation de la variable Scan
        scan = new IntentIntegrator(this.getActivity()).forSupportFragment(this);


        scanQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scan.initiateScan();
                scan.setOrientationLocked(false);
                // page2();

            }
        });
        return myView;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            // Si pas de resultat
            if (result.getContents() == null) {

            } else {

                bundle.putString("id", result.getContents());
                // Toast.makeText(getContext(),  result.getContents(), Toast.LENGTH_SHORT).show();
                //page2();


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.22.0.34:8989/web/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                WaitEasilyAPI waitEasilyAPI = retrofit.create(WaitEasilyAPI.class);
                //Response<ResponseBody> rsp = waitEasilyAPI.getCurrentTicket("countTicketBefore", idText.getText().toString());
                //nbres.setText(rsp.body().toString());


                Call<JsonObject> call = waitEasilyAPI.getCurrentTicket("countTicketBefore", result.getContents().toString());
                //System.out.println("Call " + call.request().toString());
                Log.i("REQUEST : ", call.request().toString());
//                try {
//                    List<Ticket> res = call.execute().body();
//                    bundle.putString("nb", res.toString());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                try {
                    JsonObject res = call.execute().body();
                    String jsonTicket = res.getAsString();
                    System.out.println("  JSON DATA  " + jsonTicket.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                call.enqueue(new Callback<JsonObject>() {
//
//                    @Override
//                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                        Log.i("onResponse", response.body().toString());
//                        System.out.println(response.body());
//                        if (response.isSuccessful()) {
//                            if (response.body() != null) {
//                                Log.i("onSuccess", response.body().toString());
//
//
////                                List<Ticket> t = response.body();
//
////                                for (Ticket ticket : t) bundle.putString("nb", ticket.getNbPerso());
//
////                              nbres.setText(t.getNbPerso());
//                                String jsonTicket = response.body().toString();
//                                System.out.println("  JSON DATA  " + jsonTicket.toString());
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<JsonObject> call, Throwable t) {
//
//                    }
//                });
                page2();
            }
        } else {

        }
    }

    private void page2() {
        CurrentTicketInfos fragmentTwo = new CurrentTicketInfos();
        fragmentTwo.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentOne, fragmentTwo, "fragmentTwo").addToBackStack(null).commit();

    }

}
