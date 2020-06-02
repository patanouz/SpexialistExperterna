package com.example.spexialistexperterna;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {

    Core core;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        if(getIntent().getExtras() != null) {
            core = getIntent().getParcelableExtra("core");
        }   else {
            System.out.println("Failed to fetch core");
        }





        OpenMaps();

    }

    public void OpenMaps() {

        Button register = findViewById(R.id.loginButton);


        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                core.testIncrementor();

                EditText username = findViewById(R.id.loginUsername);
                EditText password = findViewById(R.id.loginPassword);

                core.testing();





            }
        });


    }
}

