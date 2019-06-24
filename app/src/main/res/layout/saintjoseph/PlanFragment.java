package com.example.saintjoseph;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PlanFragment extends  Fragment {

    private  View myView;
    private ImageView myPlan;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        myView = inflater.inflate(R.layout.plan_fragment, container, false);
       /* myPlan=myView.findViewById(R.id.plan);
        myPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder= new AlertDialog.Builder(getContext());
                myView=getLayoutInflater().inflate(R.layout.dialog_plan,null);
                PhotoView photoView=myView.findViewById(R.id.planView);
                photoView.setImageResource(R.drawable.plan);
                mBuilder.setView(myView);
                AlertDialog mDiag=mBuilder.create();
                mDiag.show();

            }
        });*/

     return  myView;
    }

}
