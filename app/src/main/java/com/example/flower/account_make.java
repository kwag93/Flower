
package com.example.flower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class account_make extends AppCompatActivity {

    private static final String TAG = "account_make";

    TextView accountDate;
    DatePicker date;
    EditText accountContext;
    EditText accountPrice;
    Button accountSave,lookup_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_make);

        accountDate = (TextView) findViewById(R.id.account_date);
        date = findViewById(R.id.date);
        lookup_date = findViewById(R.id.lookup_date);
        accountContext = (EditText) findViewById(R.id.account_context);
        accountPrice = (EditText) findViewById(R.id.account_price);
        accountSave = (Button) findViewById(R.id.account_save);

        date.init(date.getYear(), date.getMonth(), date.getDayOfMonth(),

                new DatePicker.OnDateChangedListener() {
                    //값이 바뀔때마다 텍스트뷰의 값을 바꿔준다.

                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        // TODO Auto-generated method stub
                        //monthOfYear는 0값이 1월을 뜻하므로 1을 더해줌 나머지는 같다.
                        accountDate.setText(String.format("%d%d%d", year,monthOfYear + 1, dayOfMonth));
                    }
                });

        lookup_date.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String result = String.format("%d년 %d월 %d일을 선택하였습니다", date.getYear(), date.getMonth() + 1, date.getDayOfMonth());
                Toast.makeText(account_make.this, result, Toast.LENGTH_SHORT).show();

            }
        });


        accountSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String history= accountContext.getText().toString();
                String price= accountPrice.getText().toString();
                String date= accountDate.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { //성공
                                Toast.makeText(getApplicationContext(), "추가 성공하였습니다.", Toast.LENGTH_SHORT).show();

                            } else { // 실패
                                Toast.makeText(getApplicationContext(), "추가하지 못했습니다.", Toast.LENGTH_SHORT).show();
                                return ;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                //서버로 volley 를 이용하여 요청함
                AccountRequest accountRequest = new AccountRequest(history, price, date, responseListener);
                RequestQueue queue = Volley.newRequestQueue(account_make.this);
                queue.add(accountRequest);

            }
        });
    }
}