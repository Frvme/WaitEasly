package com.example.waiteasly;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Authentification extends Activity {

    private static  final String mylogin="appMobile";
    private static  final String mypwd="NotToday";
    private EditText pwd;
    private EditText login;

    private Button actionLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentifaction_fragment);
        pwd = findViewById(R.id.pwd);
        login= findViewById(R.id.login);
        actionLogin=findViewById(R.id.actionLogin);

        actionLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login.getText().toString().equals(mylogin) && pwd.getText().toString().equals(mypwd)){
                    launchmain();
                }else {
                    Toast.makeText(getApplicationContext(),  "Mot de passe ou identifiant incorrecte", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

        public void launchmain ()
        {
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        }

}

