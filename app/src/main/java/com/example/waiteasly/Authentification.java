package com.example.waiteasly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Authentification extends Activity {

    private static  final String mylogin="test";
    private static  final String mypwd="test";
    private EditText pwd;
    private EditText login;
    TextView inputSignup;

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

        inputSignup = findViewById(R.id.link_signup2);
        inputSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpIntent = new Intent(Authentification.this, InscriptionActivity.class);
                startActivity(signUpIntent);
            }
        });

    }

        public void launchmain ()
        {
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        }

}

