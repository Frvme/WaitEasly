package com.example.waiteasly;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

// Lib Qr Code

public class ScanFragment extends Fragment {

    private Button scanQr;
    //Qr Code variable
    private IntentIntegrator scan;
    final Bundle bundle =new Bundle();

    public ScanFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View myView=inflater.inflate(R.layout.scan_fragment, container, false);
        scanQr=myView.findViewById(R.id.scanQr);


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
                page2();

            }
        } else {

        }
    }

    private void page2(){
        TicketInfos fragmentTwo= new TicketInfos();
        fragmentTwo.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentOne,fragmentTwo,"fragmentTwo").addToBackStack(null).commit();

    }

}
