package com.example.flower;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fragment1 frag1;
    private Fragment2 frag2;
    private Fragment3 frag3;
    private Fragment4 frag4;
    private Fragment5 frag5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.action_home:
                        setFrag(0);
                        break;
                    case R.id.action_board:
                        setFrag(1);
                        break;
                    case R.id.action_calculator:
                        setFrag(2);
                        break;
                    case R.id.action_soldier:
                        setFrag(3);
                        break;
                    case R.id.action_bus:
                        setFrag(4);
                        break;
                }

                return true;
            }
        });
        frag1 = new Fragment1();
        frag2 = new Fragment2();
        frag3 = new Fragment3();
        frag4 = new Fragment4();
        frag5 = new Fragment5();
        setFrag(0); //첫 프레그먼트 화면
    }

    private void setFrag(int n){

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch(n){
            case 0:
                ft.replace(R.id.main_frame,frag1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame,frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame,frag3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame,frag4);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame,frag5);
                ft.commit();
                break;



        }
    }
}
