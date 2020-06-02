package com.example.spexialistexperterna;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterPage extends AppCompatActivity {

    Core core;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        if(getIntent().getExtras() != null) {
            core = getIntent().getParcelableExtra("core");
        }   else {
            System.out.println("Failed to fetch core");
        }

        core.testing();

        OpenLoginPage();

    }


    public void OpenLoginPage() {




        Button b = findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                core.testIncrementor();


                EditText name, city, number, email, username, password;


                /*name = findViewById(R.id.editName);
                city = findViewById(R.id.editCity);
                number = findViewById(R.id.editPhoneNumber);
                email = findViewById(R.id.editEmail);
                username = findViewById(R.id.editUsername);
                password = findViewById(R.id.editPassword);

                EditText[] arr = {name, city, number, email, username, password};

                String[] stringArr = new String[6];


                int k = 0;

                if(!number.getText().toString().isEmpty()) {
                    k = Integer.parseInt(number.getText().toString());
                }


                int i = 0;
                for(EditText e : arr) {

                    stringArr[i] = e.getText().toString();
                    i++;
                }


                Profile p = new Profile(

                        ("" + name.getText().toString()),
                        ("" + city.getText().toString()),
                        k,
                        ("" + email.getText().toString()),
                        ("" + username.getText().toString()),
                        ("" + password.getText().toString())

                );

                core.AddProfile(p); */

            }

        });


    }

        //Tanken är att denna ska göra loggan invisible för att den inte ska ligga med under skit när tangentbordet är öppet.
        //tangentbordet flyttar loggan men inte det andra för det ligger i en scrollview. Fucking shit alltså.
        //tror ej det behövs faktiskt.
        /*Button register = findViewById(R.id.button);
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                ImageView x = findViewById(R.id.slobban_white4);

                if(x.getVisibility() == View.VISIBLE) {

                    x.setVisibility(View.INVISIBLE);
                } else {
                    x.setVisibility(View.VISIBLE);
                }

            }

        });*/


}
