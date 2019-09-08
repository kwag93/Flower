package com.example.flower;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fragment3 extends Fragment {

    private View view;
    private ImageButton pickDate;
    private TextView dateDisplay;
    int mYear, mMonth, mDay;
    DatePicker mDateSetListener;

    long now = System.currentTimeMillis();
    Date date = new Date(now);      // birthday 버튼의 초기화를 위해 date 객체와 SimpleDataFormat 사용
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String result = dateFormat.format(date);

    private void UpdateNow(){
        dateDisplay.setText(String.format("%d/%d/%d", mYear, mMonth + 1, mDay));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);

        dateDisplay = (TextView) view.findViewById(R.id.dateDisplay);
        dateDisplay.setText(result);

        ImageButton pickDate = (ImageButton) view.findViewById(R.id.pickDate);
        Calendar cal = new GregorianCalendar();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        UpdateNow();

        pickDate.setOnClickListener(new View.OnClickListener() {        // 저장 버튼을 클릭하면 토스트로 고객 정보를 띄워주기
            @Override
            public void onClick(View v) {

                new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) mDateSetListener, mYear, mMonth, mDay).show();
            }

            DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    //텍스트뷰의 값을 업데이트함
                    UpdateNow();
                }
            };


        });
        return view;
    }

}