package com.example.flower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FirstAuthActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_auth);

        if(SaveSharedPreference.getUserName(FirstAuthActivity.this).length() == 0){
            // call login Activity
            intent = new Intent(FirstAuthActivity.this, LoginActivity.class);
            startActivity(intent);
            this.finish();
        } else {
            //call next Activity
            intent = new Intent(FirstAuthActivity.this, MainActivity.class);
            intent.putExtra("STD_NUM", SaveSharedPreference.getUserName(this).toString());
            startActivity(intent);
            this.finish();
        }
    }
}
