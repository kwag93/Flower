package com.example.flower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Post_make extends AppCompatActivity {

    private EditText postName, postText;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_make);

        postName = findViewById(R.id.postName);
        postText = findViewById(R.id.postText);
        btn_send = findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {         //회원가입 버튼 클릭시 수행
                //editText의 입력된 값을 get (가져오다)해옴
                String subject = postName.getText().toString();
                String text = postText.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { //게시글 등록 성공
                                Toast.makeText(getApplicationContext(), "게시글 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Post_make.this, PostActivity.class);
                                startActivity(intent);
                            } else { // 게시글 등록 실패
                                Toast.makeText(getApplicationContext(), "게시글 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                //서버로 volley 를 이용하여 요청함
                PostRequest postRequest = new PostRequest(subject, text, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Post_make.this);
                queue.add(postRequest);
            }
        });

    }
}