package com.example.waiteasly;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InscriptionActivity extends AppCompatActivity {
    EditText signUpUser;
    EditText signUpEmail;
    EditText signUpPassword;
    EditText signUpPasswordConfirm;
    Button signUpButton;
    TextView inputSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        signUpUser = findViewById(R.id.input_UserName);
        signUpEmail = findViewById(R.id.inscription_email);
        signUpPassword = findViewById(R.id.inscription_password);
        signUpPasswordConfirm = findViewById(R.id.inscription_re_password);
        inputSignIn = findViewById(R.id.link_signin2);
        inputSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = new Intent(InscriptionActivity.this, Authentification.class);
                startActivity(signInIntent);
            }
        });
    }
}
