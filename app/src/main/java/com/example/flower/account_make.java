package com.example.flower;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class account_make extends AppCompatActivity {

    private static final String TAG = "account_make";
    private Button AccountSave;
    private TextView AccountDate;
    int mYear, mMonth, mDay;
    EditText accountContext;
    EditText accountPrice;
    ArrayList<String> account_item_list;
    ArrayAdapter<String> account_adapter;



    long now = System.currentTimeMillis();
    Date date = new Date(now);      // birthday 버튼의 초기화를 위해 date 객체와 SimpleDataFormat 사용
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String result = dateFormat.format(date);

    private void UpdateNow(){
        AccountDate.setText(String.format("%d/%d/%d", mYear, mMonth + 1, mDay));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_make);
        AccountDate = (TextView) findViewById(R.id.account_date);
        AccountDate.setText(result);
        accountContext = (EditText) findViewById(R.id.account_context);
        accountPrice = (EditText) findViewById(R.id.account_price);

        account_item_list = new ArrayList<String>();
        account_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, account_item_list);

        Calendar cal = new GregorianCalendar();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        UpdateNow();

        AccountDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(account_make.this, mDateSetListener, mYear, mMonth, mDay).show();
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

        AccountSave = (Button) findViewById(R.id.account_save);
        AccountSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String str1= accountContext.getText().toString();
                String str2= accountPrice.getText().toString();
                account_item_list.add(str1);
                account_item_list.add(str2);
                account_adapter.notifyDataSetChanged();
                finish();
            }
        });
    }
}
