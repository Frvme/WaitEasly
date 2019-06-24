package com.example.saintjoseph;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private com.example.saintjoseph.RecyclerViewAdapter mAdapter;
    private List<Contact> liste= new ArrayList<>();
    public View myView;
    private String[] mot;
    private  String tempo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

       myView=inflater.inflate(R.layout.contact_fragment, container, false);


        com.example.saintjoseph.GetData service = com.example.saintjoseph.RetrofitClient.getRetrofitInstance().create(com.example.saintjoseph.GetData.class);
        Call<List<Contact>> call = null;//service.getContactBydefault(getArguments().getString("searchText"));

        if ((getArguments().getBoolean("parNom")!=true && getArguments().getBoolean("parFonction")!=true &&
                getArguments().getBoolean("parService")!=true) || (getArguments().getBoolean("parNom")==false &&
                getArguments().getBoolean("parFonction")==false && getArguments().getBoolean("parService")==false)){


            if(getArguments().getString("searchText").contains(" ")) {
                tempo = getArguments().getString("searchText").replace("  ", " ");
                mot=tempo.split(" ");
                switch (mot.length) {
                    case 1:
                        call = service.getDefaultForAll(mot[0],"neant","neant");
                        break;

                    case 2:
                        call = service.getDefaultForAll(mot[0],mot[1],"neant");
                        break;
                    case 3:
                        call = service.getDefaultForAll(mot[0],mot[1],mot[2]);
                        break;

                }
            }
            else
                call = service.getContactBydefault(getArguments().getString("searchText"));



            Toast.makeText(getContext(), "Recherche par Défaut" , Toast.LENGTH_SHORT).show();
        }
        else if (getArguments().getBoolean("parNom")==true
                && getArguments().getBoolean("parFonction")==false && getArguments().getBoolean("parService")==false){
            call = service.getContactByName(getArguments().getString("searchText"));
            Toast.makeText(getContext(), "Recherche par Nom " , Toast.LENGTH_SHORT).show();

        }
        else if ( getArguments().getBoolean("parFonction")==true
                && getArguments().getBoolean("parService")==false && getArguments().getBoolean("parNom")==false){
            call = service.getContactByProfession(getArguments().getString("searchText"));
            Toast.makeText(getContext(), "Recherche par Fonction" , Toast.LENGTH_SHORT).show();
        }
        else if (getArguments().getBoolean("parService")==true &&
                getArguments().getBoolean("parFonction")==false && getArguments().getBoolean("parNom")==false){
            call = service.getContactBySer(getArguments().getString("searchText"));
            Toast.makeText(getContext(), "Recherche par Service "  , Toast.LENGTH_SHORT).show();
        }
        else if(getArguments().getBoolean("parNom")==true && getArguments().getBoolean("parService")==true &&
                getArguments().getBoolean("parFonction")==false){
            String str =getArguments().getString("searchText");
            String[] maRecherche =str.split(" ");
            call = service.getContactByNameSer(maRecherche[0],maRecherche[1]);
            Toast.makeText(getContext(), "Recherche par Nom et Service:"+maRecherche[0]+" "+maRecherche[1]  , Toast.LENGTH_SHORT).show();
        }
        else if(getArguments().getBoolean("parNom")==true && getArguments().getBoolean("parFonction")==true && getArguments().getBoolean("parService")==false ){
            String str =getArguments().getString("searchText");
            String[] maRecherche =str.split(" ");
            call = service.getContactByNameProfession(maRecherche[0],maRecherche[1]);
            Toast.makeText(getContext(), "Recherche par Nom et Fonction:"  , Toast.LENGTH_SHORT).show();
        }else{ call = service.getContactBydefault(getArguments().getString("searchText"));}


//Execute the request asynchronously//

        call.enqueue(new Callback<List<Contact>>() {

            @Override

//Handle a successful response//

            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {

                liste=response.body();
                loadDataList(response.body());

            }



            @Override

//Handle execution failures//

            public void onFailure(Call<List<Contact>> call, Throwable throwable) {

//If the request fails, then display the following toast//

                Toast.makeText(getContext(), "Unable to load users "+ throwable.toString() , Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView = (RecyclerView) myView.findViewById(R.id.RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(myView.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new com.example.saintjoseph.RecyclerViewAdapter(liste);
        mRecyclerView.setAdapter(mAdapter);

        return myView;
    }
    private void loadDataList(List<Contact> usersList) {

//Get a reference to the RecyclerView/
        mAdapter = new com.example.saintjoseph.RecyclerViewAdapter(liste);
        mRecyclerView.setAdapter(mAdapter);


    }

}

