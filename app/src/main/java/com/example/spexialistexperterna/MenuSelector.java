package com.example.spexialistexperterna;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_menu);


        HelpSomeone();
        GetHelp();

    }

    public void HelpSomeone() {

        Button register = findViewById(R.id.giveHelp);


        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                    Intent myIntent = new Intent(view.getContext(), GiveHelp.class);
                    startActivity(myIntent);

            }
        });
    }

    public void GetHelp() {

        Button register = findViewById(R.id.getHelp);


        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {



            }
        });
    }
}
