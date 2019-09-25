package com.example.flower;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class Fragment1 extends Fragment {

    private View view;
    private ImageButton btn_logout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.frag1, container,false);

        btn_logout = (ImageButton) view.findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.clearUserName(getActivity());
                Intent intent = new Intent(getActivity(), FirstAuthActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }




}
