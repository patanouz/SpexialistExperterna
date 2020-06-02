package com.example.spexialistexperterna;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.ArrayList;
import java.util.List;


public class GiveHelp extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.give_help);







        List<String> list = new ArrayList<String>();

        list.add("Ta bort grävlingar under altanen");
        list.add("");
        list.add("Hjälp annika att ta bort grävling");
        list.add("Lovikagatan 1A");
        list.add("892 12 Leksand");
        list.add("Mobil: 0735 - 952 952");



        Spinner spin1 = findViewById(R.id.spinner);
        Spinner spin2 = findViewById(R.id.spinner5);
        Spinner spin3 = findViewById(R.id.spinner6);
        Spinner spin4 = findViewById(R.id.spinner7);

        ArrayAdapter<String> adp1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin1.setAdapter(adp1);
        spin2.setAdapter(adp1);
        spin3.setAdapter(adp1);
        spin4.setAdapter(adp1);














    }






}
