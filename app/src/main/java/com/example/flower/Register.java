package com.example.flower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Register extends AppCompatActivity {

    private ArrayAdapter adapter;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spinner = (Spinner)findViewById(R.id.spinner_area);
        adapter = ArrayAdapter.createFromResource(this,R.array.area, android. R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner = (Spinner)findViewById(R.id.spinner_category);
        adapter = ArrayAdapter.createFromResource(this,R.array.category, android. R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
}



