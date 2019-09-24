package com.example.flower;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {

    private ArrayAdapter adapter1,adapter2;
    private EditText new_email, new_pw, new_name, new_enlistdate,new_enddate ;
    private Spinner  new_type,new_area;
    private Button btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) { //액티비티 시작시 처음으로 실행되는 생명주기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //아이디값 찾아주기
        new_email = findViewById(R.id.new_email);
        new_pw = findViewById(R.id.new_pw);
        new_name = findViewById(R.id.new_name);
        new_enlistdate = findViewById(R.id.new_enlistdate);
        new_enddate = findViewById(R.id.new_enddate);

        new_type =  findViewById(R.id.new_type);
        new_area =  findViewById(R.id.new_area);

        adapter1 = ArrayAdapter.createFromResource(this, R.array.type, android.R.layout.simple_spinner_dropdown_item);
        new_type.setAdapter(adapter1);

        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {         //회원가입 버튼 클릭시 수행
                //editText의 입력된 값을 get (가져오다)해옴
                String email = new_email.getText().toString();
                String password = new_pw.getText().toString();
                String name = new_name.getText().toString();
                String enlist_date = new_enlistdate.getText().toString();
                String enlist_end_date = new_enddate.getText().toString();
                String type = new_type.getSelectedItem().toString();

                adapter2 = ArrayAdapter.createFromResource(Register.this, R.array.type, android.R.layout.simple_spinner_dropdown_item);
                new_area.setAdapter(adapter2);
                String region = new_area.getSelectedItem().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { //회원등록 성공
                                Toast.makeText(getApplicationContext(), "회원등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register.this, LoginActivity.class);
                                startActivity(intent);
                            } else { // 회원등록 식패
                                Toast.makeText(getApplicationContext(), "회원등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                //서버로 volley 를 이용하여 요청함
                RegisterRequest registerRequest = new RegisterRequest(email, password, name, enlist_date, enlist_end_date, type, region, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                queue.add(registerRequest);

            }
        });

    }
}
