package com.example.flower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Event_make extends AppCompatActivity {

    Spinner event;
    ArrayAdapter adapter;
    TextView end_date;
    EditText memo;
    DatePicker date;
    Button lookup_date;
    Button event_save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_make);

        event = findViewById(R.id.event);
        adapter = ArrayAdapter.createFromResource(this, R.array.event, android.R.layout.simple_spinner_dropdown_item);
        event.setAdapter(adapter);
        end_date = findViewById(R.id.end_date);
        lookup_date = findViewById(R.id.lookup_date);
        date = findViewById(R.id.date);
        memo = findViewById(R.id.memo);
        event_save = findViewById(R.id.event_save);
        date.init(date.getYear(), date.getMonth(), date.getDayOfMonth(),

                new DatePicker.OnDateChangedListener() {
                    //값이 바뀔때마다 텍스트뷰의 값을 바꿔준다.

                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        // TODO Auto-generated method stub
                        //monthOfYear는 0값이 1월을 뜻하므로 1을 더해줌 나머지는 같다.
                        end_date.setText(String.format("%d%d%d", year,monthOfYear + 1, dayOfMonth));
                    }
                });

        lookup_date.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String result = String.format("%d년 %d월 %d일을 선택하였습니다", date.getYear(), date.getMonth() + 1, date.getDayOfMonth());
                Toast.makeText(Event_make.this, result, Toast.LENGTH_SHORT).show();

            }
        });

        event_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = event.getSelectedItem().toString();
                String Memo = memo.getText().toString();
                String EndDate = end_date.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { //회원등록 성공
                                Toast.makeText(getApplicationContext(), "D-day 추가 성공하였습니다.", Toast.LENGTH_SHORT).show();

                            } else { // 회원등록 실패
                                Toast.makeText(getApplicationContext(), "D-day 추가하지 못했습니다.", Toast.LENGTH_SHORT).show();
                                return ;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                //서버로 volley 를 이용하여 요청함
                EventRequest eventRequest = new EventRequest(type, Memo, EndDate, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Event_make.this);
                queue.add(eventRequest);

            }
        });

    }
}
