package com.example.spexialistexperterna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Core core = new Core(new ArrayList<Profile>());

    ViewGroup view;
    Context context;

    //1 = first page, 2 = registration, 3 = login
    int currentPage = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        core.AddProfile(new Profile("Rune", "Holta", "Gatan 11", 0701234567, "noreply@slobban.se", "Bulldozer", "1"));

        view = findViewById(R.id.FirstPage);
        view.removeAllViews();

        View view1 = View.inflate(context, R.layout.first_screen, null);
        view1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.addView(view1);




        Button facebookButton = findViewById(R.id.facebookbutton);
        final Typeface typeface = ResourcesCompat.getFont(context, R.font.facebookfont);
        facebookButton.setTypeface(typeface);


        MainPageOnClickListeners();

    }


    public void LoginPage() {

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText username = findViewById(R.id.loginUsername);
                EditText password = findViewById(R.id.loginPassword);

                Profile profile;


                if((profile = core.login(username.getText().toString(), password.getText().toString())) != null) {

                    Intent myIntent = new Intent(view.getContext(), Main2Activity.class);
                    myIntent.putExtra("core", core);
                    myIntent.putExtra("profile", profile);
                    startActivity(myIntent);

                }

            }
        });


    }


    @Override
    public void onBackPressed() {

        switch (currentPage) {
            case 1:
                System.out.println("wtf are you doing");
                break;
            case 2:
                currentPage = 1;

                view.removeAllViews();
                View view1 = View.inflate(context, R.layout.first_screen, null);
                view1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                view.addView(view1);

                MainPageOnClickListeners();
                break;

        }

    }

    public void MainPageOnClickListeners() {


        Button bankidButton = findViewById(R.id.bankidbutton);
        Button facebookButton = findViewById(R.id.facebookbutton);
        Button googleButton = findViewById(R.id.googlebutton);
        Button registrationButton = findViewById(R.id.registerButton);


        bankidButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View clickView) {

                currentPage = 2;

                view.removeAllViews();
                View view1 = View.inflate(context, R.layout.login, null);
                view1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                view.addView(view1);

                LoginPage();

            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(context, "Sorry, Facebook login has not been implemented yet.", Toast.LENGTH_SHORT).show();
                System.out.println(core.getFirstProfile().getFullName());


            }
        });

        googleButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Toast.makeText(context, "Sorry, Google login has not been implemented yet.", Toast.LENGTH_SHORT).show();



            }
        });



        registrationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view2) {


                currentPage = 2;

                view.removeAllViews();
                View view1 = View.inflate(context, R.layout.registration_page, null);
                view1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                view.addView(view1);


            }
        });





    }



}

