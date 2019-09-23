package com.example.flower;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

public class Fragment4 extends Fragment {

    private View view;
    TextView textToday;
    TextView textDday;
    TextView textResult;
    Button btnDate;
    ImageButton event_make;

    int tYear;
    int tMonth;
    int tDay;

    int dYear=0;
    int dMonth=0;
    int dDay=0;

    long dday;
    long today;
    long result;

    int resultValue=0;
    Calendar calendar;  //Today
    Calendar calendar2;  //D-Day

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.frag4, container,false);


        textToday=(TextView) view.findViewById(R.id.textToday);
        textDday=(TextView) view.findViewById(R.id.textDday);
        textResult=(TextView) view.findViewById(R.id.textResult);
        btnDate=(Button) view.findViewById(R.id.btnDate);
        event_make = (ImageButton) view.findViewById(R.id.event_make);

        /* 오늘 날짜 구하기 */
        calendar=Calendar.getInstance();
        tYear=calendar.get(Calendar.YEAR);
        tMonth=calendar.get(Calendar.MONTH);
        tDay=calendar.get(Calendar.DAY_OF_MONTH);

        textToday.setText(String.format("%d.%d.%d", tYear, tMonth+1, tDay));  //오늘 날짜 출력

        /* 선택 날짜 구하기 */
        calendar2=Calendar.getInstance();
        dYear=calendar2.get(Calendar.YEAR);
        dMonth=calendar2.get(Calendar.MONTH);
        dDay=calendar2.get(Calendar.DAY_OF_MONTH);


        /*이벤트 만들기*/
        event_make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent event = new Intent(getActivity(), Event_make.class);
                startActivity(event);
            }
        });


        /* 선택 날짜 구하기 */
        btnDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new DatePickerDialog(getContext(), mDateSetListener, dYear, dMonth, dDay).show();
            }
        });
        return view;
    }

    DatePickerDialog.OnDateSetListener mDateSetListener=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            dYear=year;
            dMonth=monthOfYear;
            dDay=dayOfMonth;


            calendar2.set(Calendar.YEAR, dYear);
            calendar2.set(Calendar.MONTH, dMonth);
            calendar2.set(Calendar.DATE, dDay);

            today=calendar.getTimeInMillis()/(24*60*60*1000);
            dday=calendar2.getTimeInMillis()/(24*60*60*1000);
            result=today-dday;
            resultValue=(int)result;


            UpdateDday();

        }
    };

    void UpdateDday(){
        textDday.setText(String.format("%d.%d.%d", dYear, dMonth+1, dDay));  //선택 날짜 출력

        if(resultValue >0){
            textResult.setText("지난일정");
        }
        else if(resultValue==0){
            textResult.setText("오늘일정");
        }
        else
        {
            textResult.setText(String.format("D%d", resultValue));

        }
    }
}
