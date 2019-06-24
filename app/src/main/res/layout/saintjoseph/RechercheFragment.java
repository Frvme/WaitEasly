package com.example.saintjoseph;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;

public class RechercheFragment extends Fragment {
    String[] dico={"DSI","informatique","secretariat","medecin","Namori","Stephane","ROY","BOUDIS","RAAB","Namorigbe","marine"};
    private EditText searchText;
    private SwitchCompat parNom,parFonction,parService;

    public RechercheFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View myView=inflater.inflate(R.layout.recherche_fragment, container, false);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.select_dialog_item,dico);
        AutoCompleteTextView atx=myView.findViewById(R.id.searchText);
        atx.setThreshold(2);
        atx.setAdapter(adapter);

        atx.setTextColor(Color.parseColor("#001a33"));
        searchText=myView.findViewById(R.id.searchText);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>0)
                    myView.findViewById(R.id.clear).setVisibility(View.VISIBLE);
                else
                    myView.findViewById(R.id.clear).setVisibility(View.INVISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        parNom=myView.findViewById(R.id.parNom);
        parService=myView.findViewById(R.id.parService);
        parFonction=myView.findViewById(R.id.parFonction);

        parFonction.setChecked(true);
        parNom.setChecked(true);
        parService.setChecked(true);
        parNom.setOnCheckedChangeListener(onCheckedChanged());
        parFonction.setOnCheckedChangeListener(onCheckedChanged());
        parService.setOnCheckedChangeListener(onCheckedChanged());
        ImageButton clear_btn=myView.findViewById(R.id.clear);
        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchText.setText("");
            }
        });
        ImageButton btn =myView.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page2();
            }
        });

        return myView;
    }

    private CompoundButton.OnCheckedChangeListener onCheckedChanged() {
        return new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()) {
                    case R.id.parNom:

                        break;
                    case R.id.parFonction:

                        break;
                }
            }
        };
    }




    public void page2 ()
    {

        Bundle bundle =new Bundle();
        bundle.putString("searchText", searchText.getText().toString());
        bundle.putBoolean("parNom", parNom.isChecked());
        bundle.putBoolean("parFonction", parFonction.isChecked());
        bundle.putBoolean("parService", parService.isChecked());
        ContactFragment fragmentTwo= new ContactFragment();
        fragmentTwo.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentOne,fragmentTwo,"fragmentTwo").addToBackStack(null).commit();

    }
}
